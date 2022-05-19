package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> function;
        Consumer<List<Integer>> printing = list -> list.forEach(element -> System.out.print(element + " "));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    function = list -> list.stream().map(number -> number + 1).collect(Collectors.toList());
                    inputList = function.apply(inputList);
                    break;

                case "multiply":
                    function = list -> list.stream().map(number -> number * 2).collect(Collectors.toList());
                    inputList = function.apply(inputList);
                    break;

                case "subtract":
                    function = list -> list.stream().map(number -> number - 1).collect(Collectors.toList());
                    inputList = function.apply(inputList);
                    break;

                case "print":
                    printing.accept(inputList);
                    System.out.println();
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + input);
            }

            input = scanner.nextLine();
        }
    }
}
