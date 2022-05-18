package T05FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        Consumer<String> printCounsumer = name -> System.out.println("Sir " + name);

        Arrays.stream(array).forEach(name -> printCounsumer.accept(name));
    }
}
