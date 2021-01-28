package library.lending.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreDto {

    private Long genreId;
    private List<Long> bookIds;
    private String naming;
}
