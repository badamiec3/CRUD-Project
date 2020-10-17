package com.qa.footnote.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.footnote.domain.Book;
import com.qa.footnote.repos.BookRepo;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class BookServiceUnitTest {

	@Autowired
	private BookService service;

	@MockBean
	private BookRepo repo;

	@Test
	void testCreateBook() {

		Long id = 1L;
		Book newBook = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false, "red");
		Book savedBook = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false,
				"red");
		savedBook.setId(id);

		Mockito.when(this.repo.save(newBook)).thenReturn(savedBook);

		assertThat(this.service.createBook(newBook)).isEqualTo(savedBook);

	}

	@Test
	void testUpdateBook() {
		Long id = 1L;
		Book newBook = new Book("Building Beehives for Dummies", "Richard Rich", "Thriller", "Another description",
				false, "blue");
		Book oldBook = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false, "red");
		oldBook.setId(id);
		Book updatedBook = new Book("Building Beehives for Dummies", "Richard Rich", "Thriller", "Another description",
				false, "blue");
		updatedBook.setId(id);

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(oldBook));
		Mockito.when(this.repo.save(updatedBook)).thenReturn(updatedBook);

		assertThat(this.service.updateBook(newBook, id)).isEqualTo(updatedBook);

	}

	@Test
	void testDeleteBook() {
		Long id = 1L;
		Book toRemoveBook = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false,
				"red");
		toRemoveBook.setId(1L);

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.deleteBook(id)).isEqualTo(true);

	}

	@Test
	void testGetBook() {

		List<Book> books = new ArrayList<Book>();
		Long id = 1L;
		Book addedBook = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false,
				"red");
		addedBook.setId(id);
		books.add(addedBook);

		Mockito.when(this.repo.findAll()).thenReturn(books);

		assertThat(this.service.getBook()).isEqualTo(books);

	}

	@Test
	void testToString() {
		Book book = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false, "red");
		String testedString = book.toString();
		assertEquals(testedString,
				"Book [id=" + book.getId() + ", title=" + book.getTitle() + ", authorName=" + book.getAuthorName()
						+ ", genre=" + book.getGenre() + ", desc=" + book.getDesc() + ", nowRead=" + book.isNowRead()
						+ ", colour=" + book.getColour() + "]");

	}

}
