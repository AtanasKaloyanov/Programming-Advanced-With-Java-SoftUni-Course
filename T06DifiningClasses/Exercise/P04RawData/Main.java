package T06DifiningClasses.Exercise.P04RawData;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Car object creating and by certain
        // conditions adding it to one of the Lists:
        List<Car> fragileCars = new ArrayList<>();
        List<Car> flamableCars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            // 2.1. car model:
            String model = array[0];

            // 2.2. engine:
            int engineSpeed = Integer.parseInt(array[1]);
            int enginePower = Integer.parseInt(array[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            // 2.3. cargo:
            int cargoWeight = Integer.parseInt(array[3]);
            String cargoType = array[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            // 2.4. tires:
            double tire1Pressure = Double.parseDouble(array[5]);
            int tire1Age = Integer.parseInt(array[6]);
            Tire tire1 = new Tire(tire1Pressure, tire1Age);
            double tire2Pressure = Double.parseDouble(array[7]);
            int tire2Age = Integer.parseInt(array[8]);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            double tire3Pressure = Double.parseDouble(array[9]);
            int tire3Age = Integer.parseInt(array[10]);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            double tire4Pressure = Double.parseDouble(array[11]);
            int tire4Age = Integer.parseInt(array[12]);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            List<Tire> tires = new ArrayList<>(List.of(tire1, tire2, tire3, tire4));

            // 2.5. car adding:
            Car car = new Car(model, engine, cargo, tires);
            if (cargoType.equals("fragile") && (tire1Pressure < 1
                    || tire2Pressure < 1 || tire3Pressure < 1 || tire4Pressure < 1)) {
                fragileCars.add(car);
            } else if (cargoType.equals("flamable") && enginePower >= 250) {
                flamableCars.add(car);
            }
        }

        // 3. Final input reading and output printing:
        String neededCargoType = scanner.nextLine();
        if (neededCargoType.equals("fragile")) {
            print(fragileCars);
        } else if (neededCargoType.equals("flamable")) {
            print(flamableCars);
        }
    }

    private static void print(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getModel());
        }
    }
}