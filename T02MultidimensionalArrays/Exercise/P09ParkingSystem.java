package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        boolean[][] parking = new boolean[rows][columns];

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] array = input.split(" ");
            int entryRow = Integer.parseInt(array[0]);
            int targetRow = Integer.parseInt(array[1]);
            int targetColumn = Integer.parseInt(array[2]);

            int traveledDistance = 1;
            int zeroColumnDistance = Math.abs(entryRow - targetRow);
            traveledDistance += zeroColumnDistance;

            boolean freePlace = false;

            if (!parking[targetRow][targetColumn]) {
                traveledDistance += targetColumn;
                parking[targetRow][targetColumn] = true;
                freePlace = true;
            } else {

                for (int i = 1; i < parking[targetRow].length; i++) {

                    if (targetColumn - i > 0 && !parking[targetRow][targetColumn - i]) {
                        parking[targetRow][targetColumn - i] = true;
                        freePlace = true;
                        traveledDistance += targetColumn - i;
                        break;
                    }

                    if (targetColumn + i < parking[targetRow].length && !parking[targetRow][targetColumn + i]) {
                        parking[targetRow][targetColumn + i] = true;
                        freePlace = true;
                        traveledDistance += targetColumn + i;
                        break;
                    }

                }
            }

            if (freePlace) {
                System.out.println(traveledDistance);
            } else {
                System.out.printf("Row %d full%n", targetRow);
            }

            input = scanner.nextLine();
        }

    }
}


