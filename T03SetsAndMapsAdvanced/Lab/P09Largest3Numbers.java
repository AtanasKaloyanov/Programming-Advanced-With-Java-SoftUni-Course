package T03SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        // Input reading and printing
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder()).limit(3)
                .forEach(number -> System.out.print(number + " "));
    }
}
