package T11ExamPreparation.E12February2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(secondList);
        List<Integer> claimedItems = new ArrayList<>();

        while (!firstList.isEmpty() && !secondList.isEmpty()) {

            int firstListElement = firstList.get(0);
            int secondListElement = secondList.get(0);
            int sum = firstListElement + secondListElement;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstList.remove(0);
                secondList.remove(0);
            } else {
                secondList.remove(0);
                firstList.add(secondListElement);
            }
        }

        int sumOfTheClaimedItems = claimedItems.stream().mapToInt(element -> element).sum();

        if (firstList.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondList.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (sumOfTheClaimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sumOfTheClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sumOfTheClaimedItems);
        }
    }
}
