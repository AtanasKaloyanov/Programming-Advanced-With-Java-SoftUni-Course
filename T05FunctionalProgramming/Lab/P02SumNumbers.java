package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(", ");

        int counter = (int) Arrays.stream(numbers).map(Integer::parseInt).count();
        System.out.printf("Count = %d%n", counter);

        int sum = Arrays.stream(numbers).map(Integer::parseInt).mapToInt(element -> element).sum();
        System.out.printf("Sum = %d", sum);
    }
}
