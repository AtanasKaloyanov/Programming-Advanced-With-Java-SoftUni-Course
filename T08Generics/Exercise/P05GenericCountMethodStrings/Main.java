package T08Generics.Exercise.P05GenericCountMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();
        for (int i = 1; i <= number; i++) {
            String currentElement = scanner.nextLine();
            box.add(currentElement);
        }

        String elementForCompare = scanner.nextLine();
        System.out.println(box.countingBetterElements(elementForCompare));
    }
}
