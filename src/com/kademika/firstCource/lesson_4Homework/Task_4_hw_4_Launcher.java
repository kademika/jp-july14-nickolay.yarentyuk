package com.midgardabc.lesson_4Homework;

public class Task_4_hw_4_Launcher {

	public static void main(String[] args) {
		Library lib = new Library();
		addNewBooks(lib);
		
		lib.getBooksByName("Aname1");
		System.out.println();
		
		lib.getBooksByAuthor("Aauthor1");
		System.out.println();
		
		lib.getBooksByGenre(BookGenre.COMPUTERS);
	}
	
	static void addNewBooks(Library lib) {
		lib.addToLibrary(new Book("Aname1", "Aauthor1", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Bname2", "Aauthor1", BookGenre.FOOD));
		lib.addToLibrary(new Book("Cname3", "Bauthor2", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Aname4", "Cauthor3", BookGenre.FANTASY));
		lib.addToLibrary(new Book("Aname5", "Fauthor6", BookGenre.FICTION));
		lib.addToLibrary(new Book("Ename6", "Bauthor2", BookGenre.HISTORY));
		lib.addToLibrary(new Book("Bname7", "Dauthor4", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Gname8", "Hauthor8", BookGenre.FANTASY));
		lib.addToLibrary(new Book("Fname9", "Eauthor5", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Gname10", "Dauthor4", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Hname11", "Aauthor1", BookGenre.FANTASY));
		lib.addToLibrary(new Book("Iname12", "Aauthor1", BookGenre.FICTION));
		lib.addToLibrary(new Book("Jname13", "Cauthor3", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Kname14", "Gauthor7", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Aname1", "Aauthor1", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Mname16", "Gauthor7", BookGenre.FICTION));
		lib.addToLibrary(new Book("Nname17", "Cauthor3", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Oname18", "Gauthor7", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Pname19", "Aauthor1", BookGenre.COMPUTERS));
		lib.addToLibrary(new Book("Qname20", "Aauthor1", BookGenre.COMPUTERS));
	}
}
