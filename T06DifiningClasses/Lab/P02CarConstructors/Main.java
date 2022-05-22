package T06DifiningClasses.Lab.P02CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<CarConstructors> list = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            String[] array = scanner.nextLine().split(" ");
            CarConstructors carConstructors;

            if (array.length == 1) {
                String model = array[0];
                carConstructors = new CarConstructors(model);
            } else {
                String brand = array[0];
                String model = array[1];
                int horsePower = Integer.parseInt(array[2]);
                carConstructors = new CarConstructors(brand, model, horsePower);
            }

            list.add(carConstructors);
        }

         list.stream().forEach(car -> System.out.printf("The car is: %s %s - %d HP.%n", car.getBrand(), car.getModel(), car.getHorsePower()));
    }
}
