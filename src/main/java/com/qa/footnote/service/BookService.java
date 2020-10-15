package com.qa.footnote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.footnote.domain.Book;
import com.qa.footnote.excpetions.BookNotFoundException;
import com.qa.footnote.repos.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;

	public BookService(BookRepo repo) {
		super();
		this.repo = repo;
	}

	public Book createBook(Book book) {
		return this.repo.save(book);
	}

	public List<Book> getBook() {
		return this.repo.findAll();
	}

	public Book updateBook(Book book, Long id) {
		Book oldBook = this.repo.findById(id).orElseThrow(() -> new BookNotFoundException());

		oldBook.setTitle(book.getTitle());
		oldBook.setAuthorName(book.getAuthorName());
		oldBook.setGenre(book.getGenre());
		oldBook.setDesc(book.getDesc());
		oldBook.setNowRead(book.isNowRead());
		oldBook.setColour(book.getColour());

		return this.repo.save(oldBook);
	}

	public boolean deleteBook(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
