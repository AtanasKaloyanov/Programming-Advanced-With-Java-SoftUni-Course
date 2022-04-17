package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] array = input.split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, array);

        while (stack.size() > 1) {
            int firstElement = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int thirthElement = Integer.parseInt(stack.pop());
            int result = 0;
            if (operator.equals("+")) {
                result = firstElement + thirthElement;
                stack.push(String.valueOf(result));
            } else {
                result = firstElement - thirthElement;
                stack.push(String.valueOf(result));
            }
        }
        System.out.println(stack.peek());
    }
}
