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

        String indeces = scanner.nextLine();
        int firstElement = Integer.parseInt(indeces.split(" ")[0]);
        int secondElement = Integer.parseInt(indeces.split(" ")[1]);

        box.swap(firstElement, secondElement);

        System.out.println(box);
    }
}
