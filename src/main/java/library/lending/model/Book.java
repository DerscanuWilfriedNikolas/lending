package library.lending.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long bookId;


    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonManagedReference
    private Person person;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    public Book() {}

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId.equals(book.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }
}
