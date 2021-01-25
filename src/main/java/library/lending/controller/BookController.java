package library.lending.controller;

import library.lending.model.Book;
import library.lending.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/api/book/{id}")
    Book one(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow();
    }
}
