package T11ExamPreparation.E11June2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(", ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(", ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(secondList);

        Map<String, Integer> map = new TreeMap<>();
        map.put("Cherry Bombs", 0);
        map.put("Datura Bombs", 0);
        map.put("Smoke Decoy Bombs", 0);

        boolean are3OrMore = false;

        while (!firstList.isEmpty() && !secondList.isEmpty()) {
            are3OrMore = true;

            int firstListElement = firstList.get(0);
            int secondListElement = secondList.get(0);
            int sum = firstListElement + secondListElement;

            switch (sum) {
                case 40:
                    map.put("Datura Bombs", map.get("Datura Bombs") + 1);
                    firstList.remove(0);
                    secondList.remove(0);
                    break;

                case 60:
                    map.put("Cherry Bombs", map.get("Cherry Bombs") + 1);
                    firstList.remove(0);
                    secondList.remove(0);
                    break;

                case 120:
                    map.put("Smoke Decoy Bombs", map.get("Smoke Decoy Bombs") + 1);
                    firstList.remove(0);
                    secondList.remove(0);
                    break;


                default:
                   secondList.set(0, secondList.get(0) - 5);
                    break;
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int currentNumber = entry.getValue();
                if (currentNumber < 3) {
                    are3OrMore = false;
                    break;
                }
            }

            if (are3OrMore) {
                break;
            }
        }

        if (are3OrMore) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (firstList.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s%n", firstList.toString().replaceAll("[\\[\\]]", ""));
        }

        if (secondList.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s%n", secondList.toString().replaceAll("[\\[\\]]", ""));
        }

        map.entrySet().stream().forEach(element -> System.out.printf("%s: %d%n", element.getKey(), element.getValue()));

    }
}
