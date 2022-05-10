package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P02SetsOfElements {
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

        Set<Integer> finalSet = new LinkedHashSet<>();

        for (int currentNumber : firstSet) {
            if (secondSet.contains(currentNumber)) {
                finalSet.add(currentNumber);
            }
        }

        finalSet.forEach(e -> System.out.print(e + " "));
    }
}

