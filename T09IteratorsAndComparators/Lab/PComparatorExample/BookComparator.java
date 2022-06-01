package T09IteratorsAndComparators.Lab.PComparatorExample;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book firstBook, Book secondBook) {
        return firstBook.getTitle().compareTo(secondBook.getTitle());
    }
}
