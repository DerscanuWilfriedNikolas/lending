package library.lending.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import library.lending.exception.BookNotInPersonPossessionException;

@ControllerAdvice
public class BookNotInPersonPossessionAdvice {

    @ResponseBody
    @ExceptionHandler(BookNotInPersonPossessionException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String bookNotInPersonPossessionHandler(BookNotInPersonPossessionException ex) {
        return ex.getMessage();
    }
}
