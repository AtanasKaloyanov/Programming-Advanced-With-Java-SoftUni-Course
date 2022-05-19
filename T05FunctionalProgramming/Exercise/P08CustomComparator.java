package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(element -> Integer.parseInt(element))
                .sorted( (firstNumber, secondNumber) -> firstNumber.compareTo(secondNumber))
                .collect(Collectors.toList());

        list.stream().filter(element -> element % 2 == 0).forEach(element -> System.out.print(element + " "));
        list.stream().filter(element -> element % 2 != 0).forEach(element -> System.out.print(element + " "));
    }
}
