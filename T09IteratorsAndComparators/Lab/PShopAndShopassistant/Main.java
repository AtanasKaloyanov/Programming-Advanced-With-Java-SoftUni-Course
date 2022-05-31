package T09IteratorsAndComparators.Lab.PShopAndShopassistant;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket("banana", "apple", "orange");

        for (String currentString : supermarket) {
            System.out.println(currentString);
        }

        Iterator<String> it = supermarket.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
