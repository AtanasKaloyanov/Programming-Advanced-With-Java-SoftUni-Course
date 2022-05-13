package T03SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class P12LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMap = new TreeMap<>();
        keyMap.put("shards", 0);
        keyMap.put("fragments", 0);
        keyMap.put("motes", 0);

        Map<String, Integer> junkMap = new TreeMap<>();
        boolean isObtained = false;

        while (!isObtained) {
            String[] array = scanner.nextLine().split(" ");

            for (int i = 0; i < array.length - 1; i = i + 2) {
                int quantity = Integer.parseInt(array[i]);
                String material = array[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    keyMap.put(material, keyMap.get(material) + quantity);

                    if (keyMap.get(material) >= 250) {
                        keyMap.put(material, keyMap.get(material) - 250);

                        if (material.equals("shards")) {
                            System.out.println("Shadowmourne obtained!");
                            isObtained = true;
                            break;
                        } else if (material.equals("fragments")) {
                            System.out.println("Valanyr obtained!");
                            isObtained = true;
                            break;
                        } else if (material.equals("motes")) {
                            System.out.println("Dragonwrath obtained!");
                            isObtained = true;
                            break;
                        }
                    }

                } else {
                    junkMap.putIfAbsent(material, 0);
                    junkMap.put(material, junkMap.get(material) + quantity);
                }
            }
        }

       keyMap.entrySet().stream().sorted( (firstEntry, secondEntry) -> {
          return secondEntry.getValue().compareTo(firstEntry.getValue());
       }).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        for (Map.Entry<String, Integer> entry : junkMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}
// Shadowmourne – requires 250 Shards;
// Valanyr – requires 250 Fragments;
// Dragonwrath – requires 250 Motes;

// key materials - Shards, Fragments, and Motes
// everything else is junk

//remaining shards, fragments, motes, ordered by quantity in descending order
//remaining junk in alphabetical order



