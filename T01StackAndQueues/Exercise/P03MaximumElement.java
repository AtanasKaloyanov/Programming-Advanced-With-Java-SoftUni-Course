package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Commands implementations - 3 cases:
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String currentInput = scanner.nextLine();
            switch (currentInput) {
                case "2":
                    stack.pop();
                    break;
                case "3":
                    int maxElement = Collections.max(stack);
                    System.out.println(maxElement);
                    break;
                default:
                    String[] array = currentInput.split(" ");
                    int element = Integer.parseInt(array[1]);
                    stack.push(element);
                    break;
            }
        }

    }
}
