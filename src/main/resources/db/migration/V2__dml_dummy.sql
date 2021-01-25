INSERT INTO book (title, author)
VALUES
    ('Code Complete', 'Steve McConnell'),
    ('Java For Dummies', 'Barry A. Burd'),
    ('Modern Operating Systems', 'Andrew Tanesbraum');

INSERT INTO person (first_name, last_name, address, email)
VALUES
    ('Wilfried', 'Derscanu', 'localhost:5432', 'wilfried.derscanu@gmail.com'),
    ('Nikolas', 'Derscanu', 'localhost:8080', NULL);

UPDATE book SET person_id = 1 WHERE title = 'Code Complete';
UPDATE book SET person_id = 2 WHERE title = 'Java For Dummies';