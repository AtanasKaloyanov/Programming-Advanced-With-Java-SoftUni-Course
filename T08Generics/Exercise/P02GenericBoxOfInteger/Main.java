package T08Generics.Exercise.P02GenericBoxOfInteger;

import T08Generics.Exercise.P01GenericBox.Box;

import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int number = Integer.parseInt(scanner.nextLine());

            Box<Integer> box = new Box();

            for (int i = 1; i <= number; i++) {
                int currentNumber = Integer.parseInt(scanner.nextLine());
                box.addElement(currentNumber);
            }

            System.out.println(box);
        }
    }

