package library.lending.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import library.lending.exception.BookUnavailableException;

@ControllerAdvice
public class BookUnavailableAdvice {

    @ResponseBody
    @ExceptionHandler(BookUnavailableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String bookUnavailableHandler(BookUnavailableException ex) {
        return ex.getMessage();
    }
}
