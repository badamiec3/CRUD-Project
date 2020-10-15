DROP TABLE `book`;

CREATE TABLE book (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    authorName VARCHAR(255),
    genre VARCHAR(255),
    desc VARCHAR(255),
    nowRead BOOLEAN NOT NULL
);