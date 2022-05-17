package T05FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] array = scanner.nextLine().split(", ");
        List<Integer> list = Arrays.stream(array)
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", list.toString().replaceAll("[\\[\\]]", "")));

        Collections.sort(list);

        System.out.println(String.join(", ", list.toString().replaceAll("[\\[\\]]", "")));

    }
}
