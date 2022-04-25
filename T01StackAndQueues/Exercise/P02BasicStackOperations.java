package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        int allElementsNumber = list.get(0);
        int elementsForDeleting = list.get(1);
        int elementForChecking = list.get(2);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < allElementsNumber; i++) {
            stack.push(numbers.get(i));
        }

        for (int i = 1; i <= elementsForDeleting; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(elementForChecking)) {
                System.out.println("true");
            } else {
                int smallest = Integer.MAX_VALUE;

                while (stack.size() > 0) {
                    int current = stack.pop();
                    if (current < smallest) {
                        smallest = current;
                    }
                }
                System.out.println(smallest);
            }
        }
    }
}
