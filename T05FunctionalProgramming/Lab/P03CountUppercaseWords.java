package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        // 1. Input reading and filtering the words that begin with capital letter.
        // The filtering is done with a Predicate
        Scanner scanner = new Scanner(System.in);
        List<String> list = readList(scanner);

        // 2. Output printing:
        System.out.println(list.size());
        list.forEach(System.out::println);
    }

    private static List<String> readList(Scanner scanner) {
        Predicate<String> beginWithCapitalLetter = word -> Character.isUpperCase(word.charAt(0));

        return Arrays.stream(scanner.nextLine().split(" "))
                .filter(beginWithCapitalLetter)
                .collect(Collectors.toList());
    }
}
