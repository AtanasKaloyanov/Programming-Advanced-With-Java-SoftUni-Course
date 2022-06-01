package T09IteratorsAndComparators.Lab.P03ComparableBook;

public class Main {
    public static void main(String[] args) {

        Book firstBook = new Book("Bible", 1455);
        Book secondBook = new Book("1984", 1948, "George Orwell");
        Book thirdBook = new Book("I am number four", 2009, "James Fray", "Jobie Hughes");

        System.out.println(firstBook.compareTo(secondBook));
        System.out.println(firstBook.compareTo(thirdBook));
    }
}
