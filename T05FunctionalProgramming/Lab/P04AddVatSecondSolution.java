package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class P04AddVatSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");
        UnaryOperator<Double> unaryOperator = element -> 1.2 * element;

        Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> Double.parseDouble(element))
                .map(unaryOperator)
                .forEach(element -> System.out.printf("%.2f%n", element));
    }
}
