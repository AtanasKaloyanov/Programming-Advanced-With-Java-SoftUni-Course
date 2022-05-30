package T08Generics.Exercise.P04GenericSwapMethodsIntegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();
        for (int i = 1; i <= number ; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            box.add(currentNumber);
        }

        int firstElement = scanner.nextInt();
        int secondElement = scanner.nextInt();

        box.swap(firstElement, secondElement);

        System.out.println(box);
    }
}
