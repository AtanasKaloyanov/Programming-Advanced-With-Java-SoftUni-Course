package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
        }

        System.out.println(stack.toString().replaceAll("[\\[\\],]", ""));
    }
}
