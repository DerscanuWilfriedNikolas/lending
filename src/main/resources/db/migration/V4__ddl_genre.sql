CREATE TABLE genre (
    genre_id SERIAL PRIMARY KEY,
    naming VARCHAR(255) NOT NULL
);

INSERT INTO genre (naming)
VALUES
    ('Poetry'),
    ('Fiction'),
    ('Fantasy'),
    ('Science Fiction'),
    ('Mystery'),
    ('Biography'),
    ('Drama'),
    ('Nonfiction');

CREATE TABLE book_by_genre (
    book_id INT,
    genre_id INT
);