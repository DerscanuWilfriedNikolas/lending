package library.lending.controller;

import library.lending.model.Person;
import library.lending.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/api/person/{id}")
    public Person one(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow();
    }
}
