package T08Generics.Exercise.P01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box();

        for (int i = 1; i <= number; i++) {
            String text = scanner.nextLine();
            box.addElement(text);
        }

        System.out.println(box);
    }
}
