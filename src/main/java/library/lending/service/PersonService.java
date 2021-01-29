package library.lending.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import library.lending.dto.BookDto;
import library.lending.dto.PersonDto;
import library.lending.exception.BookNotInPersonPossessionException;
import library.lending.exception.BookUnavailableException;
import library.lending.exception.PersonNotFoundException;
import library.lending.model.Book;
import library.lending.model.Person;
import library.lending.repository.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final BookService bookService;

    public PersonService(PersonRepository personRepository, BookService bookService) {
        this.personRepository = personRepository;
        this.bookService = bookService;
    }

    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream()
                .map(this::convertToPersonDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getAllBooksByPersonId(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() ->  new PersonNotFoundException(id));

        List<Book> books = person.getBooks();

        return books.stream()
                .distinct()
                .map(bookService::convertToBookDto)
                .collect(Collectors.toList());
    }

    public BookDto rentBook(Long customerId, Long bookId) {
        Person person = personRepository.findById(customerId)
                .orElseThrow(() -> new PersonNotFoundException(customerId));
        Book book = bookService.getBookById(bookId);

        // here i am not sure if it looks ok
        Optional.ofNullable(book.getPerson())
                .ifPresentOrElse(
                        p -> {throw new BookUnavailableException(bookId);},
                        () -> book.setPerson(person));

        return bookService.convertToBookDto(bookService.update(book));
    }

    public BookDto returnBook(Long customerId, Long bookId) {
        Person person = personRepository.findById(customerId)
                .orElseThrow(() -> new PersonNotFoundException(customerId));
        Book book = bookService.getBookById(bookId);

        // here i don't know how to do it without if-else
        if (person.equals(book.getPerson())) {
            book.setPerson(null);
        } else {
            throw new BookNotInPersonPossessionException(bookId);
        }
        return bookService.convertToBookDto(bookService.update(book));
    }

    PersonDto convertToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();

        personDto.setPersonId(person.getPersonId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setAddress(person.getLastName());
        personDto.setEmail(person.getEmail());

        personDto.setBookIds(person.getBooks().stream()
                        .map(Book::getBookId)
                        .collect(Collectors.toList()));

        return personDto;
    }
}
