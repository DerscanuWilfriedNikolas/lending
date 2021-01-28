package library.lending.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Genre {

    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long genreId;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "genres", targetEntity = Book.class)
    private List<Book> books;

    private String naming;
}
