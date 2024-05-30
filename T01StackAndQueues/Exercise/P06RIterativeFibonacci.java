package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06RIterativeFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        stack.push(1L);
        stack.push(1L);

        for (int i = 1; i < number ; i++) {
            long a = stack.pop();
            long b = stack.pop();
            long c = a + b;
            stack.push(b);
            stack.push(a);
            stack.push(c);
        }
        System.out.println(stack.peek());
    }
}
