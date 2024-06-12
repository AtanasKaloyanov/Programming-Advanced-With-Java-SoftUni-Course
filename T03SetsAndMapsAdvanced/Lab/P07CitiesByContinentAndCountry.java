package T03SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Adding the input into a map
        // continent    country       town
        Map<String, Map<String, List<String>>> townsByCountryMapByContinentMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String continent = array[0];
            String country = array[1];
            String town = array[2];

            townsByCountryMapByContinentMap.putIfAbsent(continent, new LinkedHashMap<>());
            Map<String, List<String>> townsByCountry = townsByCountryMapByContinentMap.get(continent);
            townsByCountry.putIfAbsent(country, new ArrayList<>());
            townsByCountry.get(country).add(town);

            townsByCountryMapByContinentMap.put(continent, townsByCountry);
        }

        // 3. Output printing
        townsByCountryMapByContinentMap.entrySet().forEach( (outerEntry) -> {
            String continent = outerEntry.getKey();
            System.out.printf("%s:\n", continent);
            Map<String, List<String>> townsByCountry = outerEntry.getValue();
            townsByCountry.entrySet().forEach( (innerEntry) -> {
                String country = innerEntry.getKey();
                String towns = innerEntry.getValue().toString().replaceAll("[\\[\\]]", "");
                System.out.printf("  %s -> %s\n", country, towns);
            });
        });

    }
}
