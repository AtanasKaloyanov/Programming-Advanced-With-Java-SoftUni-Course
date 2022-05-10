package T03SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShopSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> map = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {

            String[] information = input.split(", ");
            String shop = information[0];
            String product = information[1];
            Double price = Double.parseDouble(information[2]);

            map.putIfAbsent(shop, new LinkedHashMap<>());
            map.get(shop).put(product, price);

            input = scanner.nextLine();
        }

      map.entrySet().stream().forEach(entry -> {
          System.out.printf("%s->%n", entry.getKey());
          entry.getValue().entrySet().stream()
                  .forEach(valueEntry -> System.out.printf("Product: %s, Price: %.1f%n", valueEntry.getKey(), valueEntry.getValue()));
      });
    }
}
