package library.lending.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookDto {

    private Long bookId;
    private Long personId;
    private List<Long> genreIds;
    private String title;
    private String author;
}
