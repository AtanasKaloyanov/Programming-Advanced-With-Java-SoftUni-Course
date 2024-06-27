package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        // 2. Consumer initializing and printing:
        Consumer<String> printer = System.out::println;
        Arrays.stream(array).forEach(printer);
    }
}
