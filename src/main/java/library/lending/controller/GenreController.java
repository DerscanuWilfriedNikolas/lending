package library.lending.controller;

import library.lending.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/*
* Show genres - read
* Find by genres - read
* */
@RestController
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;
}
