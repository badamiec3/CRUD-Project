package com.qa.footnote.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.footnote.domain.Book;
import com.qa.footnote.service.BookService;

@CrossOrigin
@RestController
public class BookController {

	private BookService service;

	public BookController(BookService service) {
		super();
		this.service = service;

	}

	@PostMapping("/createBook")
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		return new ResponseEntity<Book>(this.service.createBook(book), HttpStatus.CREATED);
	}

	@GetMapping("/getBook")
	public ResponseEntity<List<Book>> getBook() {
		return ResponseEntity.ok(this.service.getBook());
	}

	@PutMapping("/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathParam("id") Long id) {
		return new ResponseEntity<Book>(this.service.updateBook(book, id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removeBook/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable Long id) {
		if (this.service.deleteBook(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
