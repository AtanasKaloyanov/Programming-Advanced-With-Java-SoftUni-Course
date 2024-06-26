package T05FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvenOrOdds {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int begin = Integer.parseInt(array[0]);
        int end = Integer.parseInt(array[1]);
        String numberType = scanner.nextLine();

        // 2. Predicate initializing:
        Predicate<Integer> predicate;
        if (numberType.equals("even")) {
            predicate = number -> number % 2 == 0;
        } else {
            predicate = number -> number % 2 != 0;
        }

        // 3. Consumer initializing:
        Consumer<Integer> printer = x -> System.out.print(x + " ");
       List<Integer> list = new ArrayList<>();
        for (int i = begin; i <= end ; i++) {
            list.add(i);
        }

        // 4. Filtering and printing
        list.stream()
                .filter(predicate)
                .forEach(printer);

           /*  IntStream
                .rangeClosed(begin, end)
                .filter(element -> predicate.test(element))
                .boxed()
                .forEach(printer); */
    }
}
