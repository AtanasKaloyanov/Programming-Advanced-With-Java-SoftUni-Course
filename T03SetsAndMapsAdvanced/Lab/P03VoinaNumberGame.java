package T03SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println();

        for (int i = 1; i <= 50; i++) {
            if (firstPlayerCards.isEmpty()) {
                System.out.println("Second player win!");
                return;
            }

            if (secondPlayerCards.isEmpty()) {
                System.out.println("First player win");
                return;
            }

            int firstPlayerCard = firstPlayerCards.iterator().next();
            int secondPlayerCard = secondPlayerCards.iterator().next();

            firstPlayerCards.remove(firstPlayerCard);
            secondPlayerCards.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard) {
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
            } else if (secondPlayerCard > firstPlayerCard) {
                secondPlayerCards.add(firstPlayerCard);
                secondPlayerCards.add(secondPlayerCard);
            } else {
                firstPlayerCards.add(firstPlayerCard);
                secondPlayerCards.add(secondPlayerCard);
            }
        }

        int firstPlayerDeck = firstPlayerCards.size();
        int secondPlayerDeck = secondPlayerCards.size();

        if (firstPlayerDeck > secondPlayerDeck) {
            System.out.println("First player win!");
        } else if (secondPlayerDeck > firstPlayerDeck) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
