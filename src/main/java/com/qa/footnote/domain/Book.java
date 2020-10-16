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

	private String descrip;

	private boolean nowRead;

	private String colour;

	public Book() {
		super();
	}

	public Book(String title, String authorName, String genre, String descrip, boolean nowRead, String colour) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.genre = genre;
		this.descrip = descrip;
		this.nowRead = nowRead;
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authorName=" + authorName + ", genre=" + genre + ", descrip="
				+ descrip + ", nowRead=" + nowRead + ", colour=" + colour + "]";
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
		return descrip;
	}

	public void setDesc(String descrip) {
		this.descrip = descrip;
	}

	public boolean isNowRead() {
		return nowRead;
	}

	public void setNowRead(boolean nowRead) {
		this.nowRead = nowRead;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((colour == null) ? 0 : colour.hashCode());
		result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (nowRead ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (descrip == null) {
			if (other.descrip != null)
				return false;
		} else if (!descrip.equals(other.descrip))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (nowRead != other.nowRead)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
