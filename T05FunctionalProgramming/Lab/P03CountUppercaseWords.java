package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> predicate = element -> Character.isUpperCase(element.charAt(0));

        List<String> list = Arrays.stream(scanner.nextLine().split(" "))
                .filter(predicate)
                .collect(Collectors.toList());

        System.out.println(list.size());
        list.stream().forEach(element -> System.out.println(element));
    }
}
