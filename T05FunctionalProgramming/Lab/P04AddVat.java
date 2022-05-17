package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> Double.parseDouble(element))
                .map(element -> 1.2 * element)
                .forEach(element -> System.out.printf("%.2f%n", Math.abs(element)));
    }
}
