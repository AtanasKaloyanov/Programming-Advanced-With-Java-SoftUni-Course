package T09IteratorsAndComparators.Lab.P01Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book firstBook = new Book("1984", 1948, "George Orwell");
        Book secondBook = new Book("I am number 4", 2009, "James Fray", "Jobie Hughes");

        List<Book> books = new ArrayList<>();
        books.add(firstBook);
        books.add(secondBook);

        books.stream().forEach(book -> System.out.printf("Title: %s, Year: %d, Authour/s: %s%n", book.getTitle(), book.getYear(), book.getAuthors().toString().replaceAll("[\\[\\]]", "")));
    }
}
