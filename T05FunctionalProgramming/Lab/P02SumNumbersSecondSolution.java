package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbersSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");
        Function<String, Integer> function = element -> Integer.parseInt(element);

        List<Integer> list = Arrays.stream(numbers).map(function).collect(Collectors.toList());
        System.out.printf("Count = %d%n", list.size());

        int sum = Arrays.stream(numbers).mapToInt(element -> Integer.parseInt(element)).sum();
        System.out.printf("Sum = %d", sum);
    }
}
