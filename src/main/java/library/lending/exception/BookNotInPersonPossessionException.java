package library.lending.exception;

public class BookNotInPersonPossessionException extends RuntimeException {
    public BookNotInPersonPossessionException(Long id) {
        super(id + " book is not in your possesion");
    }
}
