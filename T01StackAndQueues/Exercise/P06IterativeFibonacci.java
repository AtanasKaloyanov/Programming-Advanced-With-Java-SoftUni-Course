package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06IterativeFibonacci {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Fibonacci iterative algorithm - Fist pushing the first and the second
        // number from the sequence (1, 1). Then popping the last 2 elements from the sequence,
        // calculating their sum and pushing the last number and the sum.
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);

        for (int i = 2; i <= n; i++) {
            long previousNumber = stack.pop();
            long previousButOneNumber = stack.pop();
            long sum = previousNumber + previousButOneNumber;
            stack.push(previousNumber);
            stack.push(sum);
        }

        long topNumber = stack.peek();
        System.out.println(topNumber);

        //  0 1 2 3 4 5 6
        //  1 1 2 3 5 8 13
    }
}
