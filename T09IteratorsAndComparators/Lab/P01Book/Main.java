package T09IteratorsAndComparators.Lab.P01Book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Creating 3 objects. The size of the collection
        // authors (the final parameter) is different for the
        // different objects:
        Book book1 = new Book("A", 1);
        Book book2 = new Book("B", 2, "BA");
        Book book3 = new Book("C", 3, "CA", "CB");

        // 2. Adding the books into an list and printing every book:
        List<Book> books = new ArrayList<>(List.of(book1, book2, book3));
        books.forEach(System.out::println);
    }
}
