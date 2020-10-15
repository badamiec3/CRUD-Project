package com.qa.footnote;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.footnote.domain.Book;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
class FootnoteApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void giveCoveragePlz() {
		EqualsVerifier.forClass(Book.class).usingGetClass().verify();
	}

}
