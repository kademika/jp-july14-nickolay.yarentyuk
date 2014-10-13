package com.midgardabc.lesson_4Homework;

public class Book {

	private String name;
	private String author;
	private BookGenre genre;
	
	Book() {
		
	}
	
	Book(String name, String author, BookGenre genre) {
		this.name = name;
		this.author = author;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}
	
	
	
//	Book(String name, String author, BookGenre genre) {
//		this.name = name;
//		this.author = author;
//		this.genre = genre;
//	}
//	
//	Book(Book book) {
//		name = book.name;
//		author = book.author;
//		genre = book.genre;
//	}
//	
//	public String getName() {
//		return name;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public BookGenre getGenre() {
//		return genre;
//	}
}
