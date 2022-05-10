package T03SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> store = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {

            String[] array = input.split(", ");

            String storeName = array[0];
            String product = array[1];
            double price = Double.parseDouble(array[2]);

            store.putIfAbsent(storeName, new LinkedHashMap<>());
            store.get(storeName).put(product, price);

            input = scanner.nextLine();
        }

        store.forEach( (key, value) -> {
            System.out.printf("%s->%n", key);
            value.forEach( (valueKey, valueValue) -> System.out.printf("Product: %s, Price: %.1f%n", valueKey, valueValue));
        });


    }
}// input:

//lidl, peach, 1.20
// lidl, juice, 2.30
//fantastico, apple, 1.20
//kaufland, banana, 1.10
//fantastico, grape, 2.20
//Revision

//output:

//fantastico->
//Product: apple, Price: 1.2
//Product: grape, Price: 2.2
//kaufland->
//Product: banana, Price: 1.1
//lidl->
//Product: peach, Price: 1.2
//Product: juice, Price: 2.3