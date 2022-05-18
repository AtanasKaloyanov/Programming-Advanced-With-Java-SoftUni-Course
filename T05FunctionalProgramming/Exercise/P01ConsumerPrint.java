package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        Consumer<String> printConsumer = number -> System.out.println(number);
        Arrays.stream(array)
                .forEach(element -> printConsumer.accept(element));
    }
}
