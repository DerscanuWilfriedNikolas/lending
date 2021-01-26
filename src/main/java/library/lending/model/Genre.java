package library.lending.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Genre {

    @Id @GeneratedValue
    private Long genreId;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "genres", targetEntity = Book.class)
    private List<Book> books;

    private String naming;

    public Genre() {}

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return genreId.equals(genre.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId);
    }
}
