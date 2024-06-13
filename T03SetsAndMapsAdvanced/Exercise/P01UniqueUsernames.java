package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Adding the elements to a Set
        Set<String> uniqueElements = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String currentText = scanner.nextLine();
            uniqueElements.add(currentText);
        }

        // 3. Output printing
        for (String element : uniqueElements) {
            System.out.println(element);
        }
    }
}
