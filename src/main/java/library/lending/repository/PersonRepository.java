package library.lending.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import library.lending.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {}
