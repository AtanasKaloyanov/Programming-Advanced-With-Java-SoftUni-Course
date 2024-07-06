package T08Generics.Lab.P03GenericScale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Reading 2 numbers:
        Scanner scanner = new Scanner(System.in);
        int number1 = Integer.parseInt(scanner.nextLine());
        int number2 = Integer.parseInt(scanner.nextLine());

        // 2. Initializing a variable that holds the greater number
        // For that goal we use the method getHeavier()
        Scale<Integer> scale = new Scale<>(number1, number2);
        Integer greaterNumber = scale.getHeavier();
        System.out.println(greaterNumber);
    }
}
