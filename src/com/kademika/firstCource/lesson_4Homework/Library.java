package com.midgardabc.lesson_4Homework;

public class Library {

	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private Book[][] booksByName;
	private Book[][] booksByAuthor;
	private Book[][] booksByGenre;

	public Library() {
		booksByName = new Book[26][];
		booksByAuthor = new Book[26][];
		booksByGenre = new Book[5][];
		
//		Catalog catalog = new Catalog(this);
	}

	public void addToLibrary(Book book) {
		
		int letter = alphabet.indexOf(book.getName().charAt(0));
		int position = 0;
		
		if (booksByName[letter] == null) {
			booksByName[letter] = new Book[10];
			position = 0;
		}
		else if (booksByName[letter][booksByName[letter].length-1] != null) {
			Book[] t = booksByName[letter];
			booksByName[letter] = new Book[t.length + 10];
			System.arraycopy(t, 0, booksByName[letter], 0, t.length);
			position = t.length;
		}
		else {
			for (int i = 0; i <= booksByName[letter].length; i++) {
				if (booksByName[letter][i] == null) {
					position = i;
					break;
				}
			}
		}
		booksByName[letter][position] = book;
		
		letter = alphabet.indexOf(book.getAuthor().charAt(0));
		if (booksByAuthor[letter] == null) {
			booksByAuthor[letter] = new Book[10];
			position = 0;
		}
		else if (booksByAuthor[letter][booksByAuthor[letter].length-1] != null) {
			Book[] t = booksByAuthor[letter];
			booksByAuthor[letter] = new Book[t.length + 10];
			System.arraycopy(t, 0, booksByName[letter], 0, t.length);
			position = t.length;
		}
		else {
			for (int i = 0; i <= booksByAuthor[letter].length; i++) {
				if (booksByAuthor[letter][i] == null) {
					position = i;
					break;
				}
			}
		}
		booksByAuthor[letter][position] = book;
		
		letter = book.getGenre().getId();
		if (booksByGenre[letter] == null) {
			booksByGenre[letter] = new Book[10];
			position = 0;
		}
		else if (booksByGenre[letter][booksByGenre[letter].length-1] != null) {
			Book[] t = booksByGenre[letter];
			booksByGenre[letter] = new Book[t.length + 10];
			System.arraycopy(t, 0, booksByGenre[letter], 0, t.length);
			position = t.length;
		}
		else {
			for (int i = 0; i <= booksByGenre[letter].length; i++) {
				if (booksByGenre[letter][i] == null) {
					position = i;
					break;
				}
			}
		}
		booksByGenre[letter][position] = book;
	}
	
	private void findByNameAndAuthor(String name, Book[][] criterion) {

		int letter = alphabet.indexOf(name.charAt(0));
		Book[] t = new Book[criterion[letter].length];
		Book[] books;
		
		int count = 0;

		for (int i = 0; i < criterion[letter].length; i++) {
			if (criterion[letter][i] == null)
				break;
			else if (criterion == booksByName && criterion[letter][i].getName() == name) {
				t[count] = criterion[letter][i];
				count++;
			}
			else if (criterion == booksByAuthor && criterion[letter][i].getAuthor() == name) {
				t[count] = criterion[letter][i];
				count++;
			}
		}
		
		if (count == 0)
			books = null;
		else {
			books = new Book[count];
			System.arraycopy(t, 0, books, 0, count);
		}
		printBooks (books);
	}
	
//	private Book[] findByName(String name) {
//
//		int letter = alphabet.indexOf(name.charAt(0));
//		Book[] t = new Book[booksByName[letter].length];
//		Book[] books;
//		
//		int count = 0;
//
//		for (int i = 0; i < booksByName[letter].length; i++) {
//			if (booksByName[letter][i] == null)
//				break;
//			else if (booksByName[letter][i].getName() == name) {
//				t[count] = booksByName[letter][i];
//				count++;
//			}
//		}
//		
//		if (count == 0)
//			return null;
//		else {
//			books = new Book[count];
//			System.arraycopy(t, 0, books, 0, count);
//		}
//		return books;
//	}
//
//	private Book[] findByAuthor(String author) {
//		int letter = alphabet.indexOf(author.charAt(0));
//		Book[] t = new Book[booksByAuthor[letter].length];
//		Book[] books;
//		
//		int count = 0;
//
//		for (int i = 0; i < booksByAuthor[letter].length; i++) {
//			if (booksByAuthor[letter][i] == null)
//				break;
//			else if (booksByAuthor[letter][i].getAuthor() == author) {
//				t[count] = booksByAuthor[letter][i];
//				count++;
//			}
//		}
//		
//		if (count == 0)
//			return null;
//		else {
//			books = new Book[count];
//			System.arraycopy(t, 0, books, 0, count);
//		}
//		return books;
//	}

	public void getBooksByGenre(BookGenre genre) {
		int id = genre.getId();
		Book[] books;
		
		if (booksByGenre[id] == null)
			books = null;
		else {
			Book[] t = new Book[booksByGenre[id].length];
			int count = 0;
			for (int i = 0; i < t.length; i++) {
				if (booksByGenre[id][i] == null)
					break;
				else {
					t[i] = booksByGenre[id][i];
					count++;
				}
			}
			
			books = new Book[count];
			System.arraycopy(t, 0, books, 0, count);
			
			printBooks(books);
		}
	}
	
//	private Book[] findByGenre(BookGenre genre) {
//		int id = genre.getId();
//		
//		if (booksByGenre[id] == null)
//			return null;
//		else {
//			Book[] t = new Book[booksByGenre[id].length];
//			int count = 0;
//			for (int i = 0; i < t.length; i++) {
//				if (booksByGenre[id][i] == null)
//					break;
//				else {
//					t[i] = booksByGenre[id][i];
//					count++;
//				}
//			}
//			
//			Book[] books = new Book[count];
//			System.arraycopy(t, 0, books, 0, count);
//			
//			return books;
//		}
//	}
	
	public void getBooksByName(String name) {
		findByNameAndAuthor(name, booksByName);
//		printBooks(findByName(name));
	}
	
	public void getBooksByAuthor(String author) {
		findByNameAndAuthor(author, booksByAuthor);
//		printBooks(findByAuthor(author));
	}
	
//	public void getBooksByGenre(BookGenre genre) {
//		findByGenre(genre);
////		printBooks(findByGenre(genre));
//	}
	
	private static void printBooks(Book[] books) {
		if (books == null)
			System.out.println("There is not this book.");
		else
			for (int i = 0; i < books.length; i++) {	
				System.out.println("Book: " + books[i].getName() + ", author: " + books[i].getAuthor() + ", Genre: " +
					books[i].getGenre());
			}
	}
}
