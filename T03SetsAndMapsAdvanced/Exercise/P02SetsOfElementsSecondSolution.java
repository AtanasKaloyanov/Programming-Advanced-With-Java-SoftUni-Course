package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElementsSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int firstSetSize = Integer.parseInt(array[0]);
        int secondSetSize = Integer.parseInt(array[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            int currentInt = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentInt);
        }

        for (int i = 0; i < secondSetSize; i++) {
            int currentInt = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentInt);
        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
