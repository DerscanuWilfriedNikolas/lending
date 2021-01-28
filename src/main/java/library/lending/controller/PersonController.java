package library.lending.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/api/customers")
    private List<PersonDto> all() {
        return personService.getAllPersons();
    }

    @GetMapping("/api/customers/{id}/books")
    private List<BookDto> books(@PathVariable Long id) {
        return personService.getAllBooksByPersonId(id);
    }
}
