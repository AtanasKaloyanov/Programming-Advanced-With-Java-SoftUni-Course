package T11ExamPreparation.E07April2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tullips = Arrays.stream(scanner.nextLine().split(", ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> daf = Arrays.stream(scanner.nextLine().split(", ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(tullips);
        int storedFlowers = 0;
        int bouquets = 0;

        while (!tullips.isEmpty() && !daf.isEmpty()) {
            int firstTullip = tullips.get(0);
            int firstDaf = daf.get(0);

            int sum = firstTullip + firstDaf;

            if (sum == 15) {
                tullips.remove(0);
                daf.remove(0);
                bouquets ++;
            } else if (sum > 15) {
                tullips.set(0, tullips.get(0) - 2);
            } else if (sum < 15) {
                storedFlowers += firstTullip;
                storedFlowers += firstDaf;
                tullips.remove(0);
                daf.remove(0);
            }
        }

        int bicketsFromRemainigFlower = storedFlowers / 15;
        bouquets += bicketsFromRemainigFlower;

        if (bouquets  >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets );
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets );
        }

    }
}
