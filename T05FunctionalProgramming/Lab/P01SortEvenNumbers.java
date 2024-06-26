package T05FunctionalProgramming.Lab;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class P01SortEvenNumbers {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readList(scanner);

        // 2. Removing the odd numbers via Predicate and printing
        Predicate<Integer> oddNumbersCondition = x -> x % 2 != 0;
        numbers.removeIf(oddNumbersCondition);
        printing(numbers);

        // 3. New line
        System.out.println();

        // 4. Sorting via Comparator and printing
        Comparator<Integer> comparator = Integer::compareTo;
        numbers.sort(comparator);
        printing(numbers);
    }

    private static void printing(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (i == numbers.size() - 1) {
                System.out.print(currentNumber);
                return;
            }

            System.out.print(currentNumber + ", ");
        }
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
