package T01StackAndQueues.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int[] numbers = numbersReading(scanner);
        int n = numbers[0];
        int s = numbers[1];
        int x = numbers[2];

        // 2. Adding the input into a stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .limit(n - s)
                .forEach(stack::push);

        // 3. Output printing - 3 cases:
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(x)) {
                System.out.println(true);
            } else {
                int searchedNumber = Collections.max(stack);
                System.out.println(searchedNumber);
            }
        }

    }

    private static int[] numbersReading(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
