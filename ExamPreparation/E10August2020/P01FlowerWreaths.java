package T11ExamPreparation.E10August2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> roses = Arrays.stream(scanner.nextLine().split(", ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> lilies = Arrays.stream(scanner.nextLine().split(", ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(lilies);
        int storedFlowers = 0;
        int bouquets = 0;

        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int firstRose = roses.get(0);
            int firstLilie = lilies.get(0);

            int sum = firstRose + firstLilie;

            if (sum == 15) {
                roses.remove(0);
                lilies.remove(0);
                bouquets ++;
            } else if (sum > 15) {
                lilies.set(0, lilies.get(0) - 2);
            } else if (sum < 15) {
                storedFlowers += firstRose;
                storedFlowers += firstLilie;
                roses.remove(0);
                lilies.remove(0);
            }
        }

        int bouqetsFromRemainigFlowers = storedFlowers / 15;
        bouquets += bouqetsFromRemainigFlowers;

        if (bouquets  >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", bouquets );
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - bouquets );
        }
    }
}
