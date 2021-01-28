package library.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import library.lending.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {}
