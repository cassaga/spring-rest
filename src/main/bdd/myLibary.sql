CREATE DATABASE myLibrary;

USE myLibrary;

CREATE TABLE Book (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      author VARCHAR(255) NOT NULL,
                      description TEXT
);

INSERT INTO Book (title, author, description) VALUES
                                                  ('1984', 'George Orwell', 'A dystopian novel that explores the dangers of totalitarianism'),
                                                  ('To Kill a Mockingbird', 'Harper Lee', 'A novel dealing with serious issues of race and social injustice'),
                                                  ('The Great Gatsby', 'F. Scott Fitzgerald', 'A novel about the American dream and the decadence of the jazz age');

