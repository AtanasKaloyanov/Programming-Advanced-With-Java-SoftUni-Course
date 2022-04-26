package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int elementsForAdding = scanner.nextInt();
        int elementsForDeleting = scanner.nextInt();
        int elementForChecking = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= elementsForAdding; i++) {
            queue.offer(scanner.nextInt());
        }

        for (int i = 1; i <= elementsForDeleting; i++) {
            queue.poll();
        }

        if (queue.contains(elementForChecking)) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queue));
            }
        }
    }
}
