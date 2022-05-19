package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map((number -> Integer.parseInt(number))).collect(Collectors.toList());
        int number = Integer.parseInt(scanner.nextLine());

        Collections.reverse(list);
        list.removeIf(element -> element % number == 0);
        list.stream().forEach(element -> System.out.print(element + " "));
    }
}
