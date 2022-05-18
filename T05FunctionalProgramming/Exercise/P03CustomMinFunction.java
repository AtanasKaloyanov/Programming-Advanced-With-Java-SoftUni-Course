package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> givenList = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        Function<List<Integer>, Integer> function =  list -> Collections.min(list);

        int min = function.apply(givenList);
        System.out.println(min);
    }
}
