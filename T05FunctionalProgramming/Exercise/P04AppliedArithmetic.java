package T05FunctionalProgramming.Exercise;

import T05FunctionalProgramming.Exercise2.P04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetic {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = readList(scanner);

        // 2. Commands implementation
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            Consumer<List<Integer>> consumer = null;
            switch (command) {
                case "add":
                    consumer = P04AppliedArithmetic::addingOneToEveryElement;
                    break;
                case "subtract":
                    consumer = P04AppliedArithmetic::subtractOneFromEveryElement;
                    break;
                case "multiply":
                    consumer = P04AppliedArithmetic::multiplyByTwo;
                    break;

                case "print":
                    consumer = P04AppliedArithmetic::printing;
                    break;
            }

            consumer.accept(numbers);
            command = scanner.nextLine();
        }

    }

    private static void printing(List<Integer> list) {
        list.forEach( (element) -> System.out.print(element + " "));
        System.out.println();
    }

    private static void multiplyByTwo(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int currentNumber = list.get(i);
            list.set(i, currentNumber * 2);
        }
    }

    private static void subtractOneFromEveryElement(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int currentElement = list.get(i);
            list.set(i, currentElement - 1);
        }
    }

    private static void addingOneToEveryElement(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int currentNumber = list.get(i);
            list.set(i, currentNumber + 1);
        }
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
