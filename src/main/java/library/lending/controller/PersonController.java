package library.lending.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.lending.dto.BookDto;
import library.lending.dto.PersonDto;
import library.lending.service.PersonService;

/*
* rent a book
* return a book
* check what books a person has +
* show all customers +
* */
@RestController
@RequestMapping("api/customers")
class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    private List<PersonDto> all() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}/books")
    private List<BookDto> books(@PathVariable Long id) {
        return personService.getAllBooksByPersonId(id);
    }

    @PutMapping("/{customerId}/rent/{bookId}")
    private BookDto rentBook(@PathVariable Long customerId, @PathVariable Long bookId) {
        return personService.rentBook(customerId, bookId);
    }

    @PutMapping("/{customerId}/return/{bookId}")
    private BookDto returnBook(@PathVariable Long customerId, @PathVariable Long bookId) {
        return personService.returnBook(customerId, bookId);
    }
}
