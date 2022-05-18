package T05FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrintSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(" ");

        Consumer<String[]> consumer = array -> {
            for (String name : inputArray) {
                System.out.println(name);
            }
        };

        consumer.accept(inputArray);
    }
}
