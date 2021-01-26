package library.lending.controller;

import library.lending.exception.BookNotFoundException;
import library.lending.model.Book;
import library.lending.model.Genre;
import library.lending.model.Person;
import library.lending.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private BookRepository bookRepository;

    @GetMapping("/api/books")
    List<Book> all() {
        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}/renter")
    Person renter(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id))
                .getPerson();
    }

    @GetMapping("/api/books/{id}/genres")
    List<Genre> genres(@PathVariable Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id))
                .getGenres();
    }
}
