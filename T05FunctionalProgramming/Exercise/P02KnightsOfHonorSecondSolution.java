package T05FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonorSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        Consumer<String[]> consumer = array -> {
           for (String name : array) {
               System.out.println("Sir " + name);
           }
        };

        consumer.accept(names);
    }
}
