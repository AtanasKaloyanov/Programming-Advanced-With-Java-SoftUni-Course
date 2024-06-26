package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readList(scanner);

        // 2. Creating a size function and getting the size
        Function<List<Integer>, Integer> sizeByList = List::size;
        int count = sizeByList.apply(numbers);

        // 3. Creating a sum function and getting the sum
        Function<List<Integer>, Integer> sumByList = list ->
                list.stream().mapToInt( e -> e).sum();
        int sum = sumByList.apply(numbers);

        // 4. Result printing
        System.out.printf("Count = %d\n", count);
        System.out.printf("Sum = %d", sum);
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
