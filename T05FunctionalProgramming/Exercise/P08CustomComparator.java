package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = readArray(scanner);

        // 2. Comparator implementation:
        Comparator<Integer> comp = (num1, num2) -> {
            if (num1 % 2 == 0 && num2 % 2 != 0) {
                return -1;
            } else if (num1 % 2 != 0 && num2 % 2 == 0) {
                return 1;
            }
            return num1.compareTo(num2);
        };

        // 3. Passing the array and the comparator in the sort function and printing:
        Arrays.sort(numbers, comp);
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
    }

    private static Integer[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }
}
