package T02MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][columns];

        fillMatrix(matrix,scanner);

        int maxRowIndex = rows - 1;
        int maxColumnIndex = columns - 1;

        while (maxRowIndex >= 0) {
            int row = maxRowIndex;
            int column = maxColumnIndex;
            while (column < columns && row >= 0) {
                System.out.print(matrix[row][column] + " ");
                row--;
                column++;
            }
            System.out.println();
            maxColumnIndex--;

            if (maxColumnIndex == -1) {
                maxColumnIndex = 0;
                maxRowIndex--;
            }
        }

    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] array = scanner.nextLine().split(" ");
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = Integer.parseInt(array[column]);
            }
        }
    }

}


