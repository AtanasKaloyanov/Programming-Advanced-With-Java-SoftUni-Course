package T08Generics.Exercise.P06GenericCountMethodDoubles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Box initialization and elements reading and adding to the box:
        Box<Double> box = new Box<>();
        for (int i = 0; i < n; i++) {
            Double element = Double.parseDouble(scanner.nextLine());
            box.addElement(element);
        }

        // 3. CompareElement reading and becoming the count of the better element
        // via the method greaterElementsCount()
        Double compareElement = Double.parseDouble(scanner.nextLine());
        int betterElementsCount = box.greaterElementsCount(compareElement);

        // 4. Output printing:
        System.out.println(betterElementsCount);
    }
}

