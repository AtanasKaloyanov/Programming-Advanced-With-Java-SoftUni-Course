package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> arrayDeque = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));

        // 2. Popping the first number and keeping the value as a result variable
        int result = Integer.parseInt(arrayDeque.pop());

        // 3. Result calculation via popping the current 2 element from the deque.
        // The first is an operator and the next is a number. There are 2 operators:
        while (!arrayDeque.isEmpty()) {
            String operator = arrayDeque.pop();
            int nextNumber = Integer.parseInt(arrayDeque.pop());

            if (operator.equals("+")) {
                result += nextNumber;
            } else if (operator.equals("-")) {
                result -= nextNumber;
            }
        }

        // 4. Result printing
        System.out.println(result);
    }

}
