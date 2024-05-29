package T01StackAndQueues.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P06HotPotato {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = getArrayDeque(scanner);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. The firstElement becomes last n times. This is happening until the
        // length of the queue is greater than 1
        while (queue.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                String elementOnTheTop = queue.poll();
                queue.offer(elementOnTheTop);
            }

            String removedElement = queue.poll();
            System.out.printf("Removed %s\n", removedElement);
        }

        // 3. Printing the last element
        String lastElement = queue.peek();
        System.out.printf("Last is %s", lastElement);
    }

    private static ArrayDeque<String> getArrayDeque(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}

