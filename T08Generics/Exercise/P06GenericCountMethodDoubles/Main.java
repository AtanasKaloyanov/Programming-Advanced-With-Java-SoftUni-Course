package T08Generics.Exercise.P06GenericCountMethodDoubles;

import T08Generics.Exercise.P05GenericCountMethodStrings.Box;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();
        for (int i = 1; i <= number; i++) {
            double currentNumber = Double.parseDouble(scanner.nextLine());
            box.add(currentNumber);
        }

        double numberForCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countingBetterElements(numberForCompare));
    }
}

