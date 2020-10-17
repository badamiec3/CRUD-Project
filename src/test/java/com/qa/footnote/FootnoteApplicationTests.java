package com.qa.footnote;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.footnote.domain.Book;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class FootnoteApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void coverageEquals() {
		EqualsVerifier.forClass(Book.class).usingGetClass().verify();
	}

}
