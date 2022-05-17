package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> list = Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> Double.parseDouble(element))
                .map(element -> 1.2 * element)
                .collect(Collectors.toList());

        System.out.println("Prices with VAT:");

        for (Double element : list) {
            System.out.printf("%.2f%n", Math.abs(element));
        }

    }
}
