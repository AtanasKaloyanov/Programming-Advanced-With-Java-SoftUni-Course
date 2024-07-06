package T08Generics.Exercise.P03GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Box initialization and adding every element:
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String current = scanner.nextLine();
            box.addElement(current);
        }

        // 3. Indices reading and swapping elements via swap method:
        String[] indices = scanner.nextLine().split(" ");
        int index1 = Integer.parseInt(indices[0]);
        int index2 = Integer.parseInt(indices[1]);
        box.swap(index1, index2);

        // 4. Output printing:
        System.out.println(box);
    }
}
