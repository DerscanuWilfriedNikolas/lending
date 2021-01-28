package library.lending.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonDto {

    private Long personId;
    private List<Long> bookIds;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
}
