package T06DifiningClasses.Exercise.P04RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberCars = Integer.parseInt(scanner.nextLine());

        Map<String, Car> map = new LinkedHashMap<>();

        for (int i = 1; i <= numberCars; i++) {
            String[] array = scanner.nextLine().split("\\s+");

            String model = array[0];

            int engineSpeed = Integer.parseInt(array[1]);
            int enginePower = Integer.parseInt(array[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(array[3]);
            String cargoType = array[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            double firstPressure = Double.parseDouble(array[5]);
            int firstAge = Integer.parseInt(array[6]);
            double secondPressure = Double.parseDouble(array[7]);
            int secondAge = Integer.parseInt(array[8]);
            double thirdPressure = Double.parseDouble(array[9]);
            int thirdAge = Integer.parseInt(array[10]);
            double fourthPressure = Double.parseDouble(array[11]);
            int fourthAge = Integer.parseInt(array[12]);

            Tire firstTire = new Tire(firstPressure, firstAge);
            Tire secondTire = new Tire(secondPressure, secondAge);
            Tire thirdTire = new Tire(thirdPressure, thirdAge);
            Tire fourthTire = new Tire(fourthPressure, fourthAge);

            List<Tire> tireList = new ArrayList<>(Arrays.asList(firstTire, secondTire, thirdTire, fourthTire));

            Car car = new Car(model, engine, cargo, tireList);
            map.put(model, car);

        }

        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
          map.entrySet().forEach(entry -> {

              for (Tire tire : entry.getValue().getTires()) {
                  double currentPressure = tire.getPressure();
                  if (currentPressure < 1) {
                      System.out.println(entry.getKey());
                      break;
                  }
              }
          });
                break;

            case "flamable":
                map.entrySet().forEach(entry -> {
                    int currentEnginePower = entry.getValue().getEngine().getEnginePower();
                    if (currentEnginePower > 250) {
                        System.out.println(entry.getKey());
                    }
                });
                break;
        }


    }
}