package T05FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = readList(scanner);

        // 2. Finding the smallest element and creating a function that
        // returns the rightmost index of this element:
        int smallest = Collections.min(list);
        Function<List<Integer>, Integer> smallerElementIndexOfList = l -> l.lastIndexOf(smallest);

        // 2. Index of the smallest element printing:
        int index = smallerElementIndexOfList.apply(list);
        System.out.println(index);
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}

