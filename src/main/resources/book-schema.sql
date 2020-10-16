DROP TABLE book;

CREATE TABLE book (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    author_name VARCHAR(255),
    genre VARCHAR(255),
    descrip VARCHAR(255),
    now_read BOOLEAN NOT NULL,
    colour VARCHAR(255)
);