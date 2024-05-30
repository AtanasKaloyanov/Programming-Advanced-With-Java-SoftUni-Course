package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int[] commandNumbers = readArray(scanner);
        int[] numbers = readArray(scanner);

        // 2. Offer and poll operations
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        offerCommandImplementation(commandNumbers, numbers, queue);
        pollCommandImplementation(commandNumbers, queue);

        // 3. Final printing - 3 cases:
        int x = commandNumbers[2];
        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(x)) {
                System.out.println(true);
            } else {
                int min = Collections.min(queue);
                System.out.println(min);
            }
        }
    }

    private static void pollCommandImplementation(int[] commandNumbers, ArrayDeque<Integer> queue) {
        int s = commandNumbers[1];
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
    }

    private static void offerCommandImplementation(int[] commandNumbers, int[] numbers, ArrayDeque<Integer> stack) {
        int n = commandNumbers[0];
        for (int i = 0; i < n; i++) {
            int currentNumber = numbers[i];
            stack.offer(currentNumber);
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
