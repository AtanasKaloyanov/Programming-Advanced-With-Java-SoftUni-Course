package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P07HandsOfCard {
    public static void main(String[] args) {
        // 1. Input reading and adding the information into a map
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, Set<String>> cardsByPlayer = new LinkedHashMap<>();

        while (!line.equals("JOKER")) {
            String[] array = line.split(": ");
            String playersName = array[0];
            Set<String> cards = readCards(array);
            cardsByPlayer.putIfAbsent(playersName, new HashSet<>());
            cardsByPlayer.get(playersName).addAll(cards);
            line = scanner.nextLine();
        }

        // 2. Points calculating and output printing
        cardsByPlayer.forEach((playerName, cardsSet) -> {
            Set<String> cards = cardsByPlayer.get(playerName);
            int playerResult = 0;
            for (String card : cards) {
                int currentPoints = calculatePoints(card);
                playerResult += currentPoints;
            }
            System.out.printf("%s: %s\n", playerName, playerResult);
        });
    }

    private static Set<String> readCards(String[] array) {
        return Arrays.stream(array[1].split(", "))
                .collect(Collectors.toSet());
    }

    private static int calculatePoints(String card) {
        char[] symbols = card.toCharArray();
        String type;
        char power;
        if (card.length() == 3) {
            type = "10";
            power = symbols[2];
        } else {
            type = String.valueOf(symbols[0]);
            power = symbols[1];
        }

        int typeValue = getTypeValue(type);
        int powerValue = getPowerValue(power);
        return typeValue * powerValue;
    }

    private static int getPowerValue(char power) {
        int value = 0;
        switch (power) {
            case 'S':
                value = 4;
                break;
            case 'H':
                value = 3;
                break;
            case 'D':
                value = 2;
                break;
            case 'C':
                value = 1;
                break;
        }
        return value;
    }

    private static boolean isNumber(String type) {
        try {
            int number = Integer.parseInt(type);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int getTypeValue(String type) {
        int value = 0;
        if (isNumber(type)) {
            value = Integer.parseInt(type);
        }
        switch (type) {
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
        }
        return value;
    }

}
