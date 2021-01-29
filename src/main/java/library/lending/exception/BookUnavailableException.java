package library.lending.exception;

public class BookUnavailableException extends RuntimeException {

    public BookUnavailableException(Long id) {
        super(id + " book is already rented");
    }
}
