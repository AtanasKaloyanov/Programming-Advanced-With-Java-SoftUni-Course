package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithAStackSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = array.length - 1; i >= 0 ; i--) {
            queue.offer(array[i]);
        }

        System.out.println(queue.toString().replaceAll("[\\[\\],]", ""));
    }
}
