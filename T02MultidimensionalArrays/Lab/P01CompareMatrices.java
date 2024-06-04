package T02MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        // 1. Reading the dimensions of the first matrix and initializing it.
        Scanner scanner = new Scanner(System.in);

        int[] dimensions1 = readRow(scanner);
        int rows1 = dimensions1[0];
        int columns1 = dimensions1[1];

        int[][] matrix1 = new int[rows1][columns1];
        matrix1 = readMatrix(scanner, rows1, columns1, matrix1);

        // 1.2. Matrix 2
        int[] dimensions2 = readRow(scanner);
        int rows2 = dimensions2[0];
        int columns2 = dimensions2[1];

        // 2. Comparing of the dimensions
        if (rows1 != rows2 || columns1 != columns2) {
            System.out.println("not equal");
            return;
        }

        // 3. The matrices are with equal dimensions therefore comparing of every element
        for (int i = 0; i < rows2; i++) {
            int[] currentRow2 = readRow(scanner);
            for (int j = 0; j < columns2; j++) {
                int element1 = matrix1[i][j];
                int element2 = currentRow2[j];

                if (element1 != element2) {
                    System.out.println("not equal");
                    return;
                }
            }
        }

        // 4. Printing the last case - the matrices are equal
        System.out.println("equal");
    }

    private static int[][] readMatrix(Scanner scanner, int rows1, int columns1, int[][] matrix) {
        for (int i = 0; i < rows1; i++) {
            int[] currentRow = readRow(scanner);
            for (int j = 0; j < columns1; j++) {
                matrix[i][j] = currentRow[j];
            }
        }
        return matrix;
    }

    private static int[] readRow(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
