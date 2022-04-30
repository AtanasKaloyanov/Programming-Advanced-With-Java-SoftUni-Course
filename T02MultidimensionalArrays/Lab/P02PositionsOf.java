package T02MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(array[0]);
        int columns = Integer.parseInt(array[1]);

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            for (int j = 0; j < columns; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        int searchedNumber = Integer.parseInt(scanner.nextLine());
        boolean find = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int currentNumber = matrix[i][j];

                if (searchedNumber == currentNumber) {
                    find = true;
                    System.out.print(i + " ");
                    System.out.println(j);
                }
            }
        }

        if (!find) {
            System.out.println("not found");
        }
    }
}
