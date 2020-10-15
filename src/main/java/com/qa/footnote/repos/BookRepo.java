package com.qa.footnote.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.footnote.domain.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

}
