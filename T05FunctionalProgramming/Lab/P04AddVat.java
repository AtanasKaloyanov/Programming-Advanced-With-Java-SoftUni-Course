package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class P04AddVat {
    public static void main(String[] args) {
        // 1. Creating 3 functions:
        Function<String, Double> convertingStringIntoDouble = Double::parseDouble;
        UnaryOperator<Double> adding20Percent = number -> number * 1.20;
        Consumer<Double> printer = number -> System.out.printf("%.2f\n", number);

        // 2. Reading the input than converting, adding 20% and printing via the functions:
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(convertingStringIntoDouble)
                .map(adding20Percent)
                .forEach(printer);
    }
}
