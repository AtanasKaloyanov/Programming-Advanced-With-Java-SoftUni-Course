package T03SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        Set<Integer> cards1 = readCards(scanner);
        Set<Integer> cards2 = readCards(scanner);

        int counter = 1;

        // 2. Removing the top elements from both sets and adding
        // them to the set with the better card.
        while (!cards1.isEmpty() && !cards2.isEmpty() && counter <= 50) {
            int topCards1 = cards1.iterator().next(); // top element of the set
            int topCards2 = cards2.iterator().next();
            cards1.remove(topCards1);
            cards2.remove(topCards2);

            if (topCards1 > topCards2) {
                cards1.add(topCards1);
                cards1.add(topCards2);
            } else if (topCards2 > topCards1) {
                cards2.add(topCards1);
                cards2.add(topCards2);
            }

            counter++;
        }

        // 3. Message printing - 3 cases:
        int cards1Size = cards1.size();
        int cards2Size = cards2.size();

        if (cards1Size > cards2Size) {
            System.out.println("First player win!");
        } else if (cards2Size > cards1Size) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static LinkedHashSet<Integer> readCards(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
