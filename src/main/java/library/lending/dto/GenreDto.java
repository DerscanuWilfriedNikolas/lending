package library.lending.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GenreDto {

    private Long genreId;
    private List<Long> bookIds;
    private String naming;
}
