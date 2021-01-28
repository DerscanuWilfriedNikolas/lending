package library.lending.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class BookDto {

    private Long bookId;
    private Long personId;
    private List<Long> genreIds;
    private String title;
    private String author;
}
