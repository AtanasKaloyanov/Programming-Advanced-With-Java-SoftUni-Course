package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int givenNumber = Integer.parseInt(scanner.nextLine());
        List<Integer> givenList = readList(scanner);

        // 2. BiFunction initialization:
        BiFunction<Integer, List<Integer>, Boolean> function = (number, list) -> {
            for (Integer currentNumber : list) {
                if (number % currentNumber != 0) {
                    return false;
                }
            }
            return true;
        };

        // 3. Output printing:
        for (int i = 1; i <= givenNumber; i++) {
            if (function.apply(i, givenList)) {
                System.out.print(i + " ");
            }
        }
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(element -> Integer.parseInt(element))
                .collect(Collectors.toList());
    }
}
