package T09IteratorsAndComparators.Lab.P04BookComparator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book firstBook = new Book("1984", 1948, "George Orwell");
        Book secondBook = new Book("I am number 4", 2009, "James Fray", "Jobie Hughes");
        Book thirdBook = new Book("Bible", 1455);

        List<Book> books = new ArrayList<>(Arrays.asList(firstBook, secondBook, thirdBook));
        books.sort(new BookComparator());

        for (Book currentBook : books) {
            System.out.printf("Title: %s, Year: %d, Autor/s: %s%n", currentBook.getTitle(), currentBook.getYear(), currentBook.getAuthors().toString().replaceAll("[\\[\\]]", ""));
        }


    }
}
