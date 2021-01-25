CREATE TABLE person (
    person_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

CREATE TABLE book (
    book_id SERIAL PRIMARY KEY,
    person_id int,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL
);