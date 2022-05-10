package T03SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        for (int i = 1; i <= number; i++) {
            String[] information = scanner.nextLine().split(" ");
            String continent = information[0];
            String country = information[1];
            String city = information[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new LinkedList<>());
            map.get(continent).get(country).add(city);

        }

        System.out.println();

        map.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            value.forEach((valueKey, valueValue) -> {
                System.out.printf("  %s -> ", valueKey);
                System.out.println(String.join(", ", valueValue));

            });

        });
    }
}
