package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperationsSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allElementsNumber = scanner.nextInt();
        int elementsForDeleting = scanner.nextInt();
        int elementForChecking = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= allElementsNumber ; i++) {
            stack.push(scanner.nextInt());
        }

        for (int i = 1; i <= elementsForDeleting ; i++) {
            stack.pop();
        }

        if (stack.contains(elementForChecking)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }
    }
}
