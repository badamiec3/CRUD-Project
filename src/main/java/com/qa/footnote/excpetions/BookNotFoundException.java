package com.qa.footnote.excpetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book does not exist with that ID")
public class BookNotFoundException extends RuntimeException {

}
