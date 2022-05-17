package T05FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.BiFunction;

public class PSumNumbersWithBiFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(", ");
        BiFunction<Integer, String, Integer> parseAndSum = (number, stringNumber) -> number + Integer.parseInt(stringNumber);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
           sum = parseAndSum.apply(sum, array[i]);
        }

        System.out.printf("Count = %d%n", array.length);
        System.out.printf("Sum = %d", sum);
    }
}
