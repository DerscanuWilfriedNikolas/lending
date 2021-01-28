package library.lending.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Genre {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long genreId;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "genres", targetEntity = Book.class)
    private List<Book> books;

    private String naming;
}
