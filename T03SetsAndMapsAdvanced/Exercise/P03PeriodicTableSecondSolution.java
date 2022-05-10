package T03SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTableSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();

        for (int i = 1; i <= number ; i++) {
            String[] array = scanner.nextLine().split(" ");
            set.addAll(Arrays.asList(array));
        }

        System.out.println(String.join(" ", set));
    }
}
