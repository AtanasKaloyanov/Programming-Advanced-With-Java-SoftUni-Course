package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P09PopulationCounter {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        //   country     town   population
        Map<String, Map<String, Long>> populationByTownMapByCountry = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("report")) {
            String[] array = line.split("\\|");
            String town = array[0];
            String country = array[1];
            long population = Long.parseLong(array[2]);

            populationByTownMapByCountry.putIfAbsent(country, new LinkedHashMap<>());
            Map<String, Long> populationByTownMap = populationByTownMapByCountry.get(country);
            populationByTownMap.put(town, population);
            populationByTownMapByCountry.put(country, populationByTownMap);

            line = scanner.nextLine();
        }

        // 2. Output printing after sorting the outer and the inner map
        populationByTownMapByCountry.entrySet().stream()
                // 2.1. Outer map sorting
                .sorted( (entry1, entry2) -> {
                    Map<String, Long> populationByTown1 = entry1.getValue();
                    Map<String, Long> populationByTown2 = entry2.getValue();
                    long totalPopulation1 = getTotalPopulation(populationByTown1);
                    long totalPopulation2 = getTotalPopulation(populationByTown2);

                    return Long.compare(totalPopulation2, totalPopulation1);
                    // 2.2. Inner map sorting
                }).forEach( (entry) -> {
                    String country = entry.getKey();
                    Map<String, Long> populationByTown = entry.getValue();
                    long totalPopulation = getTotalPopulation(populationByTown);
                    System.out.printf("%s (total population: %d)\n", country, totalPopulation);
                    populationByTown.entrySet().stream()
                            .sorted( (innerEntry1, innerEntry2) -> {
                                long population1 = innerEntry1.getValue();
                                long population2 = innerEntry2.getValue();
                                return Long.compare(population2, population1);
                            }).forEach( (innerEntry) -> {
                                String town = innerEntry.getKey();
                                long population = innerEntry.getValue();
                                System.out.printf("=>%s: %d\n", town, population);
                            });
                });
    }

    private static long getTotalPopulation(Map<String, Long> populationByTown1) {
        return populationByTown1.values().stream().mapToLong(e -> e).sum();
    }
}

