package library.lending.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import library.lending.exception.GenreNotFoundException;

@ControllerAdvice
class GenreNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(GenreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String bookNotFoundHandler(GenreNotFoundException ex) {
        return ex.getMessage();
    }
}
