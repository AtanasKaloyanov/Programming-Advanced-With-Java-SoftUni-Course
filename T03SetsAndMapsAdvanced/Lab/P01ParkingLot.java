package T03SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] array = input.split(", ");
            String command = array[0];
            String carNumber = array[1];

            switch (command) {
                case "IN":
                    parking.add(carNumber);
                    break;

                case "OUT":
                    parking.remove(carNumber);
                    break;
            }

            input = scanner.nextLine();
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String currentCar : parking) {
                System.out.println(currentCar);
            }
        }
    }
}
