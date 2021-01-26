package library.lending.controller;

import library.lending.exception.GenreNotFoundException;
import library.lending.model.Book;
import library.lending.model.Genre;
import library.lending.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* Find by genres +
* Show genres +
* */
@RestController
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping("/api/genres")
    public List<Genre> all() {
        return genreRepository.findAll();
    }

    @GetMapping("/api/genres/{id}/books")
    public List<Book> books(@PathVariable Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id))
                .getBooks();
    }
}