package T03SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P09Largest3NumbersSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .sorted(
                        (left, right) -> right.compareTo(left)
                ).limit(3)
                .forEach(number -> System.out.print(number + " "));
    }
}
