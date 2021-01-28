package library.lending.service;

import library.lending.dto.BookDto;
import library.lending.dto.GenreDto;
import library.lending.dto.PersonDto;
import library.lending.exception.BookNotFoundException;
import library.lending.model.Book;
import library.lending.model.Genre;
import library.lending.model.Person;
import library.lending.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDto> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(BookService::convertToBookDto)
                .collect(Collectors.toList());
    }

    public PersonDto getRenterByBookId(Long id) {
        Person person = bookRepository
                    .findById(id)
                    .orElseThrow(() -> new BookNotFoundException(id))
                    .getPerson();
        return PersonService.convertToPersonDto(person);
    }

    public List<GenreDto> getGenresByBookId(Long id) {
        List<Genre> genres = bookRepository
                        .findById(id)
                        .orElseThrow(() -> new BookNotFoundException(id))
                        .getGenres();
        return genres
                            .stream()
                            .map(GenreService::convertToGenreDto)
                            .collect(Collectors.toList());
    }

    static BookDto convertToBookDto(Book book) {
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
