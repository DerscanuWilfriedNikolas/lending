package library.lending.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import library.lending.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.lending.dto.BookDto;
import library.lending.dto.GenreDto;
import library.lending.dto.PersonDto;
import library.lending.exception.BookNotFoundException;
import library.lending.model.Book;
import library.lending.model.Genre;
import library.lending.model.Person;
import library.lending.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreService genreService;

    @Autowired
    private PersonService personService;

    public List<BookDto> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(this::convertToBookDto)
                .collect(Collectors.toList());
    }

    public PersonDto getRenterByBookId(Long id) {
        Person person = bookRepository
                    .findById(id)
                    .orElseThrow(() -> new BookNotFoundException(id))
                    .getPerson();
        return personService.convertToPersonDto(person);
    }

    public List<GenreDto> getGenresByBookId(Long id) {
        List<Genre> genres = bookRepository
                        .findById(id)
                        .orElseThrow(() -> new BookNotFoundException(id))
                        .getGenres();
        return genres
                            .stream()
                            .map(g -> genreService.convertToGenreDto(g))
                            .collect(Collectors.toList());
    }

    public BookDto addBook(BookDto bookDto) {
        Book book = bookRepository.save(convertToBook(bookDto));
        return convertToBookDto(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    Book convertToBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPerson(null);

        book.setGenres(bookDto.getGenreIds().stream()
                .map(i -> genreService.getById(i))
                .collect(Collectors.toList()));

        return book;
    }

    BookDto convertToBookDto(Book book) {
        BookDto bookDto = new BookDto();

        bookDto.setBookId(book.getBookId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());

        bookDto.setPersonId(
                Optional.ofNullable(book.getPerson()).isPresent()
                ? book.getPerson().getPersonId() : null);

        bookDto.setGenreIds(
                book.getGenres()
                        .stream()
                        .map(Genre::getGenreId)
                        .collect(Collectors.toList()));

        return bookDto;
    }

}
