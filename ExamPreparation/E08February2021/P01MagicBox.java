package T11ExamPreparation.E08February2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> secondBox = Arrays.stream(scanner.nextLine().split("\\s+")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(secondBox);
        List<Integer> claimedItems = new ArrayList<>();

        while(!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstBoxFirstElement = firstBox.get(0);
            int secondBoxFirstElement = secondBox.get(0);

            int sum = firstBoxFirstElement + secondBoxFirstElement;

            if (sum % 2 == 0) {
                firstBox.remove(0);
                secondBox.remove(0);
                claimedItems.add(sum);
            } else {
                secondBox.remove(0);
                firstBox.add(secondBoxFirstElement);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        int claimedItemsSum = claimedItems.stream().mapToInt(element -> element).sum();

        if (claimedItemsSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", claimedItemsSum);
        } else {
            System.out.printf("Poor prey... Value: %d", claimedItemsSum);
        }
     }
}
