package T11ExamPreparation.E03December2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> males = Arrays.stream(scanner.nextLine().split("\\s+")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> females = Arrays.stream(scanner.nextLine().split("\\s+")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(males);

        int counter = 0;
        while (!males.isEmpty() && !females.isEmpty()) {
            int firstMaleNumber = males.get(0);
            int firstFemaleNumber = females.get(0);

            if (firstMaleNumber <= 0) {
                males.remove(0);
            } else if (firstFemaleNumber <= 0) {
                females.remove(0);
            } else if (firstMaleNumber % 25 == 0) {
                males.remove(0);
                males.remove(0);
            } else if (firstFemaleNumber % 25 == 0) {
                females.remove(0);
                females.remove(0);
            } else if (firstMaleNumber == firstFemaleNumber) {
                counter++;
                males.remove(0);
                females.remove(0);
            } else if (firstMaleNumber != firstFemaleNumber) {
                females.remove(0);
                males.set(0, males.get(0) - 2);
            }
        }

        System.out.printf("Matches: %d%n", counter);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.printf("Males left: %s%n", males.toString().replaceAll("[\\[\\]]", ""));
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.printf("Females left: %s", females.toString().replaceAll("[\\[\\]]", ""));
        }
        //Matches: 4
        //Males left: none
        //Females left: 15, 13, 4

    }
}

