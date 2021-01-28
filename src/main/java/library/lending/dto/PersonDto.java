package library.lending.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

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
