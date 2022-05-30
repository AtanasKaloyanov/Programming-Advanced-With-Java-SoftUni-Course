package T08Generics.Exercise.P03GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 1; i <= number ; i++) {
            String element = scanner.nextLine();
            box.add(element);
        }

        int firstElement = scanner.nextInt();
        int secondElement = scanner.nextInt();

        box.swap(firstElement, secondElement);

        System.out.println(box);
    }
}
