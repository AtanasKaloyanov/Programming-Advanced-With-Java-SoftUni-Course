package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P09ListOfPredicatesSecondSolution {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = readList(scanner);

        // 2. Predicate and Consumer implementation:
        Predicate<Integer> isDivisible = number -> {
            for (Integer currentNumber : numbers) {
                if (number % currentNumber != 0) {
                    return false;
                }
            }
            return true;
        };
        Consumer<Integer> printer = number -> System.out.print(number + " ");

        // 3. Creating an IntStream and passing the predicate and the consumer:
        IntStream.range(1, n + 1)
                .boxed()
                .filter(isDivisible)
                .forEach(printer);
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
