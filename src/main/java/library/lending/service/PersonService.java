package library.lending.service;

import library.lending.dto.BookDto;
import library.lending.dto.PersonDto;
import library.lending.exception.PersonNotFoundException;
import library.lending.model.Book;
import library.lending.model.Person;
import library.lending.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonDto> getAllPersons() {
        return personRepository.findAll().stream()
                .map(PersonService::convertToPersonDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getAllBooksByPersonId(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() ->  new PersonNotFoundException(id));

        List<Book> books = person.getBooks();

        return books.stream()
                .distinct()
                .map(BookService::convertToBookDto)
                .collect(Collectors.toList());
    }

    static PersonDto convertToPersonDto(Person person) {
        PersonDto personDto = new PersonDto();

        personDto.setPersonId(person.getPersonId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setAddress(person.getLastName());
        personDto.setEmail(person.getEmail());

        personDto.setBookIds(person.getBooks()
                        .stream()
                        .map(Book::getBookId)
                        .collect(Collectors.toList()));

        return personDto;
    }
}
