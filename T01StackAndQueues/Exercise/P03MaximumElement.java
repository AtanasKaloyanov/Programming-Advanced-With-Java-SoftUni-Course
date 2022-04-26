package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= numberCommands; i++) {
            String[] array = scanner.nextLine().split(" ");
            String currentCommand = array[0];

            switch (currentCommand) {
                case "1":
                    int elementForPushing = Integer.parseInt(array[1]);
                    stack.push(elementForPushing);
                    break;

                case "2":
                    stack.pop();
                    break;

                case "3":
                    if (stack.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(Collections.max(stack));
                    }
                    break;
            }
        }
    }
}
