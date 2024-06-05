package T02MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        // 1. Matrix reading
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[] row1 = readRow(scanner);
        int columns = row1.length;

        int[][] matrix = new int[rows][columns];
        matrix[0] = row1;

        matrixFilling(scanner, rows, columns, matrix);

        // 2. Finding the wrong element
        int[] wrongDimensions = readRow(scanner);
        int wrongRow = wrongDimensions[0];
        int wrongColumn = wrongDimensions[1];
        int wrongElement = matrix[wrongRow][wrongColumn];

        // 3. Creating a final matrix and filling it
        int[][] resultMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int current = matrix[i][j];
                if (current == wrongElement) {
                    int left = 0;
                    int up = 0;
                    int right = 0;
                    int down = 0;

                    if (j - 1 >= 0 && matrix[i][j - 1] != wrongElement) {
                        left = matrix[i][j - 1];
                    }
                    if (i - 1 >= 0 && matrix[i - 1][j] != wrongElement) {
                        up = matrix[i - 1][j];
                    }
                    if (j + 1 < columns && matrix[i][j + 1] != wrongElement) {
                        right = matrix[i][j + 1];
                    }
                    if (i + 1 < rows && matrix[i + 1][j] != wrongElement) {
                        down = matrix[i + 1][j];
                    }

                    int sum = left + up + right + down;
                    resultMatrix[i][j] = sum;
                } else {
                    resultMatrix[i][j] = current;
                }
            }
        }

        // 4. Output printing
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void matrixFilling(Scanner scanner, int rows, int columns, int[][] matrix) {
        for (int i = 1; i < rows; i++) {
            int[] currentRow = readRow(scanner);
            for (int j = 0; j < columns; j++) {
                int currentElement = currentRow[j];
                matrix[i][j] = currentElement;
            }
        }
    }

    private static int[] readRow(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
