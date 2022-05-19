package T05FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> givenList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        int smallestNumber = Collections.min(givenList);

        Function<List<Integer>, Integer> function = list -> list.lastIndexOf(smallestNumber);
        System.out.println(function.apply(givenList));

    }
}

