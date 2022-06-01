package T09IteratorsAndComparators.Lab.PComparatorExample;


public class Main {
    public static void main(String[] args) {
        Book firstBook = new Book("1984", 1948, "George Orwell");
        Book secondBook = new Book("I am number 4", 2009, "James Fray", "Jobie Hughes");

        BookComparator bookComparator = new BookComparator();
        System.out.println(bookComparator.compare(firstBook, secondBook));
    }
}
