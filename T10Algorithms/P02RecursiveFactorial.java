package T10Algorithms;

import java.util.Scanner;

public class P02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(factorialCalculation(number));
    }

    public static int factorialCalculation(int number) {

        if (number == 0) {
            return 1;
        }

        return number * factorialCalculation(number - 1);
    }

}
