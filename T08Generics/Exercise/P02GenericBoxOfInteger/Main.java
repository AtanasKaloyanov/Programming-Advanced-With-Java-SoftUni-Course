package T08Generics.Exercise.P02GenericBoxOfInteger;

import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            // 1. Input reading:
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());

            // 2. Adding every element to the object's List via the method addElement()
            Box<Integer> box = new Box<>();
            for (int i = 0; i < n; i++) {
                Integer element = Integer.parseInt(scanner.nextLine());
                box.addElement(element);
            }

            // 3. Object printing via the overridden method toString()
            System.out.println(box);
        }
    }

