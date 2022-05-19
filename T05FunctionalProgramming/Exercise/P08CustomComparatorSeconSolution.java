package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparatorSeconSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(element -> Integer.parseInt(element))
                .collect(Collectors.toList());

        Comparator<Integer> comparator = (firstNumber, secondNumber) -> {
            if ((firstNumber % 2 == 0 && secondNumber % 2 != 0)) {
                return -1;
            } else if (firstNumber % 2 != 0 && secondNumber % 2 == 0) {
                return 1;
            }
            return firstNumber.compareTo(secondNumber);
        };

        list.stream().sorted(comparator).forEach(element -> System.out.print(element + " "));
    }
}
