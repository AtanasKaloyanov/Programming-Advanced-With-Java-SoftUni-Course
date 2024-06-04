package T02MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        // 1.1. Dimensions reading
        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int columns = dimensions[1];

        // 1.2. Matrix initializing and reading
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] currentRow = readArray(scanner);
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        // 1.3. Searching number reading
        int searchedNumber = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        // 2. Nested cycles looping and by every match printing
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int currentNumber = matrix[i][j];

                if (currentNumber == searchedNumber) {
                    isFound = true;
                    System.out.println(i + " " + j);
                }
            }

        }

        // 3. Final case printing by non-existing number
        if (!isFound) {
            System.out.println("not found");
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
