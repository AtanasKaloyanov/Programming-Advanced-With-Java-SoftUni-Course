package T11ExamPreparation.E01April2022.P03Basket;

import java.util.*;
import java.util.stream.Collectors;

public class P01Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> steel = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> carbon = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        Collections.reverse(carbon);

        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);

        while (!steel.isEmpty() && !carbon.isEmpty()) {
            int firstElementSteel = steel.get(0);
            int firstElementCarbon = carbon.get(0);
            int sum = firstElementSteel + firstElementCarbon;

            switch (sum) {
                case 70:
                    steel.remove(0);
                    carbon.remove(0);
                    swords.put("Gladius", swords.get("Gladius") + 1);
                    break;

                case 80:
                    steel.remove(0);
                    carbon.remove(0);
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                    break;

                case 90:
                    steel.remove(0);
                    carbon.remove(0);
                    swords.put("Katana", swords.get("Katana") + 1);
                    break;

                case 110:
                    steel.remove(0);
                    carbon.remove(0);
                    swords.put("Sabre", swords.get("Sabre") + 1);
                    break;

                default:
                    steel.remove(0);
                    carbon.set(0, carbon.get(0) + 5);
                    break;
            }

        }

        int swordsSum = swords.values().stream().mapToInt(element -> element).sum();

        if (swordsSum == 0) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            System.out.printf("You have forged %d swords.%n", swordsSum);
        }

        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.printf("Steel left: %s%n", steel.toString().replaceAll("[\\[\\]]", ""));
        }

        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.printf("Carbon left: %s%n", carbon.toString().replaceAll("[\\[\\]]", ""));
        }

        swords.entrySet().stream().filter(entry -> entry.getValue() > 0).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
