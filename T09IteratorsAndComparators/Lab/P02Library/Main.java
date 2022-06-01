package T09IteratorsAndComparators.Lab.P02Library;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
           Book firstBook = new Book("Bible", 1455);
           Book secondBook = new Book("1984", 1948, "George Orwell");
           Book thirdBook = new Book("I am number four", 2009, "James Fray", "Jobie Hughes");

           Library library= new Library(firstBook, secondBook, thirdBook);

        for (Book currentBook : library) {
            System.out.printf("Title: %s, Year: %d, Autor/s: %s%n", currentBook.getTitle(), currentBook.getYear(), currentBook.getAuthor().toString().replaceAll("[\\[\\]]", ""));
        }

        Iterator<Book> it = library.iterator();
        while(it.hasNext()) {
            Book currentBook = it.next();
            System.out.printf("Title: %s, Year: %d, Autor/s: %s%n", currentBook.getTitle(), currentBook.getYear(), currentBook.getAuthor().toString().replaceAll("[\\[\\]]", ""));

        }
    }
}
