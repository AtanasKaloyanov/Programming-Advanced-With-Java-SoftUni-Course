package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        Integer[] array = readArray(scanner);

        // 2. getMin function initializing:
        Function<Integer[], Integer> getMin = arr ->
                Arrays.stream(arr).mapToInt(e -> e).min().getAsInt();

        // 3. Min finding and printing:
        int min = getMin.apply(array);
        System.out.println(min);
    }

    private static Integer[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
