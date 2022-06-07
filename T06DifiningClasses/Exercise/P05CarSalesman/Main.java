package T06DifiningClasses.Exercise.P05CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int engineNumber = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();

        for (int i = 1; i <= engineNumber; i++) {
            String[] engineArray = scanner.nextLine().split("\\s+");
            String model = engineArray[0];
            int power = Integer.parseInt(engineArray[1]);

            int displacement = 0;
            String efficiency = null;
            if (engineArray.length == 3) {
                if (Character.isDigit(engineArray[2].charAt(0))) {
                    displacement = Integer.parseInt(engineArray[2]);
                } else {
                    efficiency = engineArray[2];
                }

            } else if (engineArray.length == 4) {
                displacement = Integer.parseInt(engineArray[2]);
                efficiency = engineArray[3];
            }

            Engine engine = new Engine(model, power, displacement, efficiency);
            engineList.add(engine);
        }

        int carNumbers = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= carNumbers; i++) {
            String[] carArray = scanner.nextLine().split("\\s+");
            String model = carArray[0];
            String engine = carArray[1];

            int weight = 0;
            String colour = null;

            if (carArray.length == 3) {
                if (Character.isDigit(carArray[2].charAt(0))) {
                    weight = Integer.parseInt(carArray[2]);
                } else {
                    colour = carArray[2];
                }
            } else if (carArray.length == 4) {
                weight = Integer.parseInt(carArray[2]);
                colour = carArray[3];
            }

            Engine engine1 = null;

            for (Engine currentEngine : engineList) {
                if (currentEngine.getModel().equals(engine)) {
                    engine1 = currentEngine;
                }
            }

            Car car = new Car(model, engine1, weight, colour);
            System.out.print(car);
        }


    }
}
