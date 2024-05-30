package T01StackAndQueues.Exercise;

import java.util.Scanner;

public class P06RecursiveFibonacci {
    private static long[] numbers;

    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        numbers = new long[n + 1];

        // 2. Fibonacci recursive algorithm
        long fibonacciNumber = getFibonacci(n);

        // 3. Output printing
        System.out.println(fibonacciNumber);
    }

    private static long getFibonacci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        // Instead of new calculations of something that is already calculated just
        // getting the number from the array
        if (numbers[n] != 0) {
            return numbers[n];
        }

        long previousNumber = getFibonacci(n - 1);
        long previousButOneNumber = getFibonacci(n - 2);
        long sum = previousNumber + previousButOneNumber;
        // keeping the sum for argument n on the nth position in the array
        numbers[n] = sum;
        return sum;
    }
}
