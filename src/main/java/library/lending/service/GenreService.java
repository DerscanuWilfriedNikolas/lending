package library.lending.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.lending.dto.BookDto;
import library.lending.dto.GenreDto;
import library.lending.exception.GenreNotFoundException;
import library.lending.model.Book;
import library.lending.model.Genre;
import library.lending.repository.GenreRepository;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<GenreDto> getAllGenres() {
        return genreRepository.findAll()
                .stream()
                .map(GenreService::convertToGenreDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getAllBooksByGenreId(Long id) {
        List<Book> books = genreRepository
                .findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id))
                .getBooks();

        return books.stream()
                .map(BookService::convertToBookDto)
                .collect(Collectors.toList());
    }

    static GenreDto convertToGenreDto(Genre genre) {
        GenreDto genreDto = new GenreDto();

        genreDto.setGenreId(genre.getGenreId());
        genreDto.setNaming(genre.getNaming());

        genreDto.setBookIds(genre.getBooks()
                        .stream()
                        .map(Book::getBookId)
                        .collect(Collectors.toList()));

        return genreDto;
    }
}
