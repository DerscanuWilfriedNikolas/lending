package library.lending.controller;

import library.lending.dto.BookDto;
import library.lending.dto.GenreDto;
import library.lending.dto.PersonDto;
import library.lending.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* add new book
* delete book
* check who rented the book +
* inspect book genres +
* show all books +
* */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/api/books")
    @ResponseBody
    private List<BookDto> all() {
        return bookService.getAllBooks();
    }

    @GetMapping("/api/books/{id}/renter")
    private PersonDto renter(@PathVariable Long id) {
        return bookService.getRenterByBookId(id);
    }

    @GetMapping("/api/books/{id}/genres")
    private List<GenreDto> genres(@PathVariable Long id) {
        return bookService.getGenresByBookId(id);
    }
}
