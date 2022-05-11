package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P08HandsOfCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] array = input.split(":");
            String name = array[0];
            String cards = array[1];

            String[] arrayCards = cards.split(",");

            for (int i = 0; i < arrayCards.length; i++) {
                String currentCard = arrayCards[i].trim();
                map.putIfAbsent(name, new LinkedHashSet<>());
                map.get(name).add(currentCard);
            }

            input = scanner.nextLine();
        }

        map.forEach((key, value) -> {
            System.out.printf("%s: ", key);

            int sum = 0;
            int realSize = value.size();

            for (int i = 0; i < realSize; i++) {
                String currentCard = value.iterator().next();
                value.remove(currentCard);

                int powerInt = 0;
                int typerInt = 0;

                char power = currentCard.charAt(0);
                powerInt = getPowerInt(power, powerInt);

                char type;

                if (power != '1') {
                    type = currentCard.charAt(1);
                } else {
                    type = currentCard.charAt(2);
                }

                typerInt =  getTypeInt(type, typerInt);

                int currentSum = powerInt * typerInt;
                sum += currentSum;

            }
            System.out.printf("%d%n", sum);
        });
    }

    private static int getTypeInt(char type, int typerInt) {
        switch (type) {
            case 'S':
                typerInt = 4;
                break;

            case 'H':
                typerInt = 3;
                break;

            case 'D':
                typerInt = 2;
                break;

            case 'C':
                typerInt = 1;
                break;
        }
        return typerInt;
    }

    private static int getPowerInt(char power, int powerInt) {
        switch (power) {
            case '2':
                powerInt = 2;
                break;

            case '3':
                powerInt = 3;
                break;

            case '4':
                powerInt = 4;
                break;

            case '5':
                powerInt = 5;
                break;

            case '6':
                powerInt = 6;
                break;

            case '7':
                powerInt = 7;
                break;

            case '8':
                powerInt = 8;
                break;

            case '9':
                powerInt = 9;
                break;

            case '1':
                powerInt = 10;
                break;

            case 'J':
                powerInt = 11;
                break;

            case 'Q':
                powerInt = 12;
                break;

            case 'K':
                powerInt = 13;
                break;

            case 'A':
                powerInt = 14;
                break;
        }
        return powerInt;
    }

}
