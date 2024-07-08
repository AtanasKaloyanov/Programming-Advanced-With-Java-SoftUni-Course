package T09IteratorsAndComparators.Lab.P02Library;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return this.books;
    }

    public class LibIterator implements Iterator<Book> {
        private int counter;

        @Override
        public boolean hasNext() {
            return this.counter < getBooks().length;
        }

        @Override
        public Book next() {
            Book currentBook = getBooks()[this.counter];
            this.counter += 2;
            return currentBook;
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new  LibIterator();
    }
}
