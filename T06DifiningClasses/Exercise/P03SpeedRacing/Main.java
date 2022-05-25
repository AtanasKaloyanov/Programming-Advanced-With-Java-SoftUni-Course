package T06DifiningClasses.Exercise.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberCars = Integer.parseInt(scanner.nextLine());

        Map<String, Car> map = new LinkedHashMap<>();

        for (int i = 1; i <= numberCars ; i++) {
            String[] array = scanner.nextLine().split("\\s+");

            String model = array[0];
            int fuelAmount = Integer.parseInt(array[1]);
            double fuelFor1Km = Double.parseDouble(array[2]);

            Car car = new Car(model, fuelAmount, fuelFor1Km);
            map.put(model, car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] array = input.split("\\s+");

            String model = array[1];
            int distance = Integer.parseInt(array[2]);

            if (map.get(model).isTheFuelEnough(distance)) {

                map.get(model).setFuelAmount(distance);
                map.get(model).setAmountKilometers(distance);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }
        
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getValue().toString()));
    }
}
