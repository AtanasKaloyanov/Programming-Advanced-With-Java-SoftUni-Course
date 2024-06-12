package T03SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        // 1. Adding the products into a map
        Map<String, Map<String, Double>> priceByProductMapByShop = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("Revision")) {
            String[] array = line.split(", ");
            String shopName = array[0];
            String product = array[1];
            double price = Double.parseDouble(array[2]);

            priceByProductMapByShop.putIfAbsent(shopName, new LinkedHashMap<>());
            Map<String, Double> productByPrice = priceByProductMapByShop.get(shopName);
            productByPrice.put(product, price);

            priceByProductMapByShop.put(shopName, productByPrice);
            line = scanner.nextLine();
        }

        // 2. Output printing
        priceByProductMapByShop.entrySet().forEach( (outerEntry) -> {
            String shopName = outerEntry.getKey();
            System.out.printf("%s->\n", shopName);
            Map<String, Double> pricesByProducts = outerEntry.getValue();
            pricesByProducts.entrySet().forEach( (innerEntry) -> {
                String product = innerEntry.getKey();
                double price = innerEntry.getValue();
                System.out.printf("Product: %s, Price: %.1f\n", product, price);
            });
        });

    }
}

/*
//Input 1:

lidl, peach, 1.20
 lidl, juice, 2.30
fantastico, apple, 1.20
kaufland, banana, 1.10
fantastico, grape, 2.20
Revision

output:

fantastico->
Product: apple, Price: 1.2
Product: grape, Price: 2.2
kaufland->
Product: banana, Price: 1.1
lidl->
Product: peach, Price: 1.2
Product: juice, Price: 2.3

 */