package T06DifiningClasses.Exercise.P03SpeedRacing;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Adding the cars into a map:
        Map<String, Car> carsByModelMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String model = array[0];
            double fuelAmount = Double.parseDouble(array[1]);
            double fuelFor1Km = Double.parseDouble(array[2]);
            Car car = new Car(model, fuelAmount, fuelFor1Km);
            carsByModelMap.put(model, car);
        }

        // 3. Commands implementation:
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            // 3.1. Given array
            String[] array = line.split(" ");
            String model = array[1];
            if (!carsByModelMap.containsKey(model)) {
                line = scanner.nextLine();
                continue;
            }

            // 3.2. NeededFuel for the distance computation:
            Car searchedCar = carsByModelMap.get(model);
            double currentFuel = searchedCar.getFuelAmount();
            double fuelFor1Km = searchedCar.getFuelCostFor1Km();
            double givenDistance = Double.parseDouble(array[2]);

            double neededFuel = givenDistance * fuelFor1Km;
            if (currentFuel < neededFuel) {
                System.out.println("Insufficient fuel for the drive");
                line = scanner.nextLine();
                continue;
            }

            searchedCar.travelDistance(neededFuel, givenDistance);
            line = scanner.nextLine();
        }

        // 3. Printing:
        carsByModelMap.values()
                .forEach( (System.out::println));
    }

}

/*
  class Car
    1. String model;
    2. double fuelAmount;
    3. int fuelCostFor1Km;

    // Input 1:
    Cars:
      AudiA4 {23 0.3},  BMW-M2 - {45,  0.42}

     1. BMW-M2 56 -> BMW-42 travelledKM = 56 * 0.42 = 23.52  |  AudiA4 {23 0.3},  BMW-M2 - {21.48,  0.42}
     2. AudiA4 5  -> AudiA4 travelledKM = 5 * 0.3 = 1.5      |  AudiA4 {21.5 0.3},  BMW-M2 - {21.48,  0.42}
     3. AudiA4 13 -> AudiA4 travelledKM = 13 * 0.3 = 3.9  |  AudiA4 {17.60 0.3},  BMW-M2 - {21.48,  0.42}
 */
