package library.lending.controller;

import library.lending.exception.PersonNotFoundException;
import library.lending.model.Book;
import library.lending.model.Person;
import library.lending.repository.BookRepository;
import library.lending.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* rent a book
* return a book
* check what books a person has +
* show all customers +
* */
@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/api/customers")
    public List<Person> all() {
        return personRepository.findAll();
    }

    @GetMapping("/api/customers/{id}/books")
    public List<Book> books(@PathVariable Long id) {
        return bookRepository.findAllByPerson(
                personRepository.findById(id)
                        .orElseThrow(() -> new PersonNotFoundException(id))
        );
    }
}
