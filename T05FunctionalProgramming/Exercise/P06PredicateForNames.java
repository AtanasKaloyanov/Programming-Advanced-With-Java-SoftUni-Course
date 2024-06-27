package T05FunctionalProgramming.Exercise;


import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        // 1. Predicate and Consumer initialization:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<String> hasLength = word -> word.length() <= n;
        Consumer<String> printer = System.out::println;

        // 2. Numbers reading and printing:
        Arrays.stream(scanner.nextLine().split(" "))
                .filter(hasLength)
                .forEach(printer);
    }
}
