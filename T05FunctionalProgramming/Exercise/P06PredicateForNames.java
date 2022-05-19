package T05FunctionalProgramming.Exercise;


import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberSymbols = Integer.parseInt(scanner.nextLine());
        String[] array = scanner.nextLine().split(" ");

        Predicate<Integer> predicate = symbols -> symbols <= numberSymbols;
        
        Arrays.stream(array).
                filter(element -> predicate.test(element.length()))
                .forEach(element -> System.out.println(element));
    }
}
