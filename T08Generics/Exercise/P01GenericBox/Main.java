package T08Generics.Exercise.P01GenericBox;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Adding every element to the object's List via the method addElement()
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String element = scanner.nextLine();
            box.addElement(element);
        }

        // 3. Object printing via the overridden method toString()
        System.out.println(box);
    }
}
