package com.qa.footnote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String authorName;

	private String genre;

	private String desc;

	private boolean nowRead;

	public Book() {
		super();
	}

	public Book(String title, String authorName, String genre, String desc, boolean nowRead) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.genre = genre;
		this.desc = desc;
		this.nowRead = nowRead;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authorName=" + authorName + ", genre=" + genre + ", desc="
				+ desc + ", nowRead=" + nowRead + "]";
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isNowRead() {
		return nowRead;
	}

	public void setNowRead(boolean nowRead) {
		this.nowRead = nowRead;
	}

	// Generate hash and equals for testing

}
