package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P03CustomMinFunctionSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> inputList = Arrays.stream(scanner.nextLine().split(" "))
                .map(element -> Integer.parseInt(element))
                .collect(Collectors.toList());

        Consumer<List<Integer>> printConsumer =  list -> System.out.println(Collections.min(list));
        printConsumer.accept(inputList);
    }
}
