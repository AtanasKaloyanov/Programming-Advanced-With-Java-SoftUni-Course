package T06DifiningClasses.Exercise.P05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Creating engine and adding it to a engineMap:
        Map<String, Engine> enginesByModel = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 2.1. Engine fields reading:
            String[] engineArray = scanner.nextLine().split(" ");
            String model = engineArray[0];
            String power = engineArray[1];
            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineArray.length == 4) {
                displacement = engineArray[2];
                efficiency = engineArray[3];
            } else if (engineArray.length == 3) {
                String displacementOrEfficiency = engineArray[2];
                if (isNumber(displacementOrEfficiency)) {
                    displacement = displacementOrEfficiency;
                } else {
                    efficiency = displacementOrEfficiency;
                }
            }

            // 2.2. Engine creating:
            Engine engine = new Engine(model, power, displacement, efficiency);
            enginesByModel.put(model, engine);
        }

        // 3. Creating car and adding it to the carSet:
        Set<Car> cars = new LinkedHashSet<>();
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carArray = scanner.nextLine().split(" ");
            // 2.1. Car fields reading:
            String model = carArray[0];
            String engineModel = carArray[1];

            if (!enginesByModel.containsKey(engineModel)) {
                continue;
            }

            Engine engine = enginesByModel.get(engineModel);
            String weight = "n/a";
            String color = "n/a";

            if (carArray.length == 4) {
                weight = carArray[2];
                color = carArray[3];
            } else if (carArray.length == 3) {
                String weightOrColor = carArray[2];
                if (isNumber(weightOrColor)) {
                    weight = weightOrColor;
                } else {
                    color = weightOrColor;
                }
            }

            // 2. Adding the car into a set:
            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }

        // 3. Printing:
        for (Car car : cars) {
            System.out.println(car);
        }

    }

    private static boolean isNumber(String displacementOrEfficiency) {
        try {
            int displacement = Integer.parseInt(displacementOrEfficiency);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
