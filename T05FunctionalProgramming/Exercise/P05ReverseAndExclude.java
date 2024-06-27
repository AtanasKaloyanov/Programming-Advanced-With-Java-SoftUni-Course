package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = readList(scanner);
        int divider = Integer.parseInt(scanner.nextLine());

        // 2. Reversing:
        Collections.reverse(list);

        // 3. Predicate and Consumer initialization:
        Predicate<Integer> isDivisible = number -> number % divider == 0;
        Consumer<Integer> printer = number -> System.out.print(number + " ");

        // 3. Removing and printing via the predicate and the consumer:
        list.removeIf(isDivisible);
        list.forEach(printer);
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
