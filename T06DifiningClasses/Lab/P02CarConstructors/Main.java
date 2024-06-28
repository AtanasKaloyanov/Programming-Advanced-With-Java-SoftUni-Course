package T06DifiningClasses.Lab.P02CarConstructors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Creating carConstructor object using one of
        // the constructors and printing it.
        for (int i = 1; i <= n; i++) {
            String[] array = scanner.nextLine().split(" ");
            CarConstructors carConstructor;
            String brand = array[0];

            if (array.length == 1) {
                carConstructor = new CarConstructors(brand);
            } else {
                String model = array[1];
                int horsePower = Integer.parseInt(array[2]);
                carConstructor = new CarConstructors(brand, model, horsePower);
            }

            System.out.println(carConstructor);
        }
    }
}
