package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExcludeSecondSolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());

        int givenNumber = Integer.parseInt(scanner.nextLine());

        Collections.reverse(list);
        Predicate<Integer> predicate = currentNumber -> currentNumber % givenNumber != 0;

        list.stream()
                .filter(element -> predicate.test(element))
                .forEach(element -> System.out.print(element + " "));

    }
}
