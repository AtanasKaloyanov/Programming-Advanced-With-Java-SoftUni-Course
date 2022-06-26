package T10Algorithms;

import java.util.Scanner;

public class PRecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(factorialCalculation(number));
    }

    public static int factorialCalculation(int number) {
        int numberBeforeReducing = number;
        number--;

        if (number == 0) {
            return 1;
        }

        return numberBeforeReducing * factorialCalculation(number);
    }

}
