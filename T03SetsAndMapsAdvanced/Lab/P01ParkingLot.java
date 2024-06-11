package T03SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P01ParkingLot {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        // 2. Commands implementation in Set. 2 cases - adding and removing:
        Set<String> carNumbers = new LinkedHashSet<>();
        while (!line.equals("END")) {
            String[] currentArray = line.split(", ");
            String currentCommand = currentArray[0];
            String currentCarNumber = currentArray[1];

            switch (currentCommand) {
                case "IN":
                    carNumbers.add(currentCarNumber);
                    break;

                case "OUT":
                    carNumbers.remove(currentCarNumber);
                    break;
            }

            line = scanner.nextLine();
        }

        // 3. Car numbers printing: 2 cases:
        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            carNumbers.forEach(System.out::println);
        }
    }
}
