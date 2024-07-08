package T09IteratorsAndComparators.Lab.P04BookComparator;


import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            // 1. Creating 5 book objects:
            Book book1 = new Book("A", 1);
            Book book2 = new Book("B", 2, "a");
            Book book3 = new Book("C", 3, "a", "b");
            Book book4 = new Book("D", 4, "a", "b", "c");
            Book book5 = new Book("E", 5, "a", "b", "c", "d");

            // 2. Adding the books into a collection disordered:
            List<Book> booksCollection = new ArrayList<>(List.of(book2, book4, book3, book5, book1));

            // 3. Sorting the books and printing them:
            BookComparator bookComparator = new BookComparator();
            booksCollection.stream()
                    .sorted(bookComparator)// There is no need for a Comparator because the Book class implements Comparator<Book>
                    .forEach(System.out::println);
        }
    }
