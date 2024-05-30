package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        // 1. Adding the input into an ArrayDeque
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(stack::push);

        // 2. Output printing
        System.out.println(stack.toString().replaceAll("[\\[\\],]", ""));
    }
}
