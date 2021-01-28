package library.lending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.lending.dto.BookDto;
import library.lending.dto.GenreDto;
import library.lending.service.GenreService;

/*
* Find by genres +
* Show genres +
* */
@RestController
@RequestMapping("api/genres")
class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    private List<GenreDto> all() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}/books")
    private List<BookDto> books(@PathVariable Long id) {
        return genreService.getAllBooksByGenreId(id);
    }
}