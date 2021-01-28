package library.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import library.lending.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {}
