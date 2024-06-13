package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P02SetsOfElements {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(array[0]);
        int n2 = Integer.parseInt(array[1]);

        // 2. Adding the elements to the both sets
        Set<String> set1 = new LinkedHashSet<>();
        for (int i = 0; i < n1; i++) {
            String currentElement = scanner.nextLine();
            set1.add(currentElement);
        }

        // 3. If the set contains the current element => printing
        Set<String> set2 = new LinkedHashSet<>();
        for (int i = 0; i < n2; i++) {
            String currentElement = scanner.nextLine();
            set2.add(currentElement);
        }

        // 4. Finding the section of the sets and printing
        set1.retainAll(set2);
        String result = set1.toString().replaceAll("[\\[\\],]", "");
        System.out.println(result);
    }
}

