package library.lending.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.lending.dto.BookDto;
import library.lending.dto.GenreDto;
import library.lending.dto.PersonDto;
import library.lending.service.BookService;

/*
* add new book +
* delete book +
* check who rented the book +
* inspect book genres +
* show all books +
* */
@RestController
@RequestMapping("api/books")
class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<BookDto> all() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}/renter")
    private PersonDto renter(@PathVariable Long id) {
        return bookService.getRenterByBookId(id);
    }

    @GetMapping("/{id}/genres")
    private List<GenreDto> genres(@PathVariable Long id) {
        return bookService.getGenresByBookId(id);
    }

    @PostMapping("/add")
    private BookDto addBook(@RequestBody BookDto book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("{id}/dispose")
    private void disposeBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
