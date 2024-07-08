package T09IteratorsAndComparators.Lab.P02Library;


public class Main {
    public static void main(String[] args) {
        // 1. Creating 5 book objects:
        Book book1 = new Book("A", 1);
        Book book2 = new Book("B", 2, "a");
        Book book3 = new Book("C", 3, "a", "b");
        Book book4 = new Book("D", 4, "a", "b", "c");
        Book book5 = new Book("E", 5, "a", "b", "c", "d");

        // 2. Creating an instance of the class Library:
        Library library = new Library(book1, book2, book3, book4, book5);

        // 3. default void forEach(Consumer<? super T> action)
        library.forEach(System.out::println);
    }
}
