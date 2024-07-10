package T09IteratorsAndComparators.Exercise.P04Froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. Lake object creating and adding the number to the lake via while cycle:
        Lake lake = new Lake();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            List<Integer> list = readList(scanner, line);
            lake.addPositions(list);
            line = scanner.nextLine();
        }

        // 2. Result list creating and via forEach() method iteration over the numbers:
        List<Integer> result = new ArrayList<>();
        lake.forEach(result::add);

        // 3. Result printing:
        System.out.println(result.toString().replaceAll("[\\[\\]]", ""));
    }

    private static List<Integer> readList(Scanner scanner, String line) {
        return Arrays.stream(line.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
