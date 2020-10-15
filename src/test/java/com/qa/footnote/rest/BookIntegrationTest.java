package com.qa.footnote.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.footnote.domain.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:book-schema.sql",
		"classpath:book-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class BookIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreateBook() throws Exception {
		Book newBook = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false);
		String requestBody = this.mapper.writeValueAsString(newBook);

		RequestBuilder request = post("/createBook").contentType(MediaType.APPLICATION_JSON).content(requestBody);

		ResultMatcher checkStatus = status().isCreated();

		Book savedBook = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false);
		savedBook.setId(2L);

		String resultBody = this.mapper.writeValueAsString(savedBook);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testRemoveBook() throws Exception {

		RequestBuilder request1 = delete("/removeBook/1");
		ResultMatcher checkStatus1 = status().isOk();

		this.mockMVC.perform(request1).andExpect(checkStatus1);

		// MvcResult result1 =
		// this.mockMVC.perform(request1).andExpect(checkStatus1).andReturn();

	}

	@Test
	void testReadBook() throws Exception {
		Book book = new Book("Building Beehives for Dummies", "Robert Bob", "Thriller", "Description", false);
		book.setId(1L);
		List<Book> books = new ArrayList<>();
		books.add(book);
		String responseBody = this.mapper.writeValueAsString(books);
		System.out.println();
		this.mockMVC.perform(get("/getBook")).andExpect(status().isOk()).andExpect(content().json(responseBody));

	}

	@Test
	void testUpdateBook() throws Exception {
		Long id = 1L;
		Book updatedBook = new Book("Title", "Author", "Genre", "Desc", true);
		String requestBody = this.mapper.writeValueAsString(updatedBook);
		RequestBuilder request = put("/updateBook?id=" + id).contentType(MediaType.APPLICATION_JSON)
				.content(requestBody);

		ResultMatcher checkStatus = status().isAccepted();

		Book returnedBook = new Book("Title", "Author", "Genre", "Desc", true);
		returnedBook.setId(id);

		String resultBody = this.mapper.writeValueAsString(returnedBook);
		ResultMatcher checkBody = content().json(resultBody);

		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);

	}

}
