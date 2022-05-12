package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Step 1 -> Filling the Map

        Map<String, Map<String, Long>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] array = input.split("\\|");

            String country = array[1];
            String city = array[0];
            long population = Long.parseLong(array[2]);

            map.putIfAbsent(country, new LinkedHashMap<>());
            map.get(country).putIfAbsent(city, population);

            input = scanner.nextLine();
        }

        map.entrySet().stream().sorted((firstEntry, secondEntry) -> {
            long firstCountryPopulation = firstEntry.getValue().values().stream().mapToLong(l -> l).sum();
            long secondCountryPopulation = secondEntry.getValue().values().stream().mapToLong(l -> l).sum();

            return Long.compare(secondCountryPopulation, firstCountryPopulation);

        }).forEach(entry -> {
            long currentTotalPopulation = entry.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.printf("%s (total population: %d)%n", entry.getKey(), currentTotalPopulation);

            entry.getValue().entrySet().stream().sorted( (firstInternalEntry, secondInternalEntry) ->
                    Long.compare(secondInternalEntry.getValue(), firstInternalEntry.getValue()))
                    .forEach( internalEntry -> System.out.printf("=>%s: %d%n", internalEntry.getKey(), internalEntry.getValue()));
        });
        
    }
}

