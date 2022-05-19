package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P07FindTheSmallestElementSecondSolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> givenList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        int smallestNumber = Collections.min(givenList);
        
        Consumer<List<Integer>> consumer = list -> System.out.println(givenList.lastIndexOf(smallestNumber));
        consumer.accept(givenList);
    }
}
