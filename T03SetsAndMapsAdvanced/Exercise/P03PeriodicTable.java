package T03SetsAndMapsAdvanced.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(array));
        }

        // 3. Elements printing
        String result = elements.toString().replaceAll("[\\[\\],]", "");
        System.out.println(result);
    }
}
