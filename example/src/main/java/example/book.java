package example;

import java.io.Serializable;

public class book implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String author;
	private Integer year;
	
	public book(String title, String author, Integer year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Integer getYear() {
		return year;
	}
	public String toString() {
		return "Book: Title:(" + title + "), Author:(" + author + "), Year:(" + year + ")";
	}
}
