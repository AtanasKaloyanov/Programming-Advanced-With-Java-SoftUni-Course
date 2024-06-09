package T02MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        // 1. Matrix reading
        Scanner scanner = new Scanner(System.in);
        int[] coordinates = readRow(scanner);
        int rows = coordinates[0];
        int columns = coordinates[1];

        int[][] matrix = fillingMatrix(scanner, rows);

        // 2. Printing diagonals

        // 2.1. Initializing start rows and start columns
        int startRow = rows - 1;
        int startColumn = columns - 1;

        // 2.2. Starting cycle until the start row is 0 or greater
        while (startRow >= 0) {
            // 2.3. Initializing print row and print column
            int printRow = startRow;
            int printColumn = startColumn;

            // 2.4 diagonal printing until the row and column are in the matrix
            while (printRow >= 0 && printColumn < columns) {
                int currentElement = matrix[printRow][printColumn];
                System.out.print(currentElement + " ");

                printRow--;
                printColumn++;
            }

            // 2.5. After the printing of the diagonal row is the new line printing
            System.out.println();

            // 2.6. Updating the start column and the start row
            startColumn--;
            if (startColumn == -1) {
                startColumn = 0;
                startRow--;
            }
        }
    }

    private static int[][] fillingMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] currentRow = readRow(scanner);
            matrix[i] = currentRow;
        }
        return matrix;
    }

    private static int[] readRow(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}

/*
Input 1:

      0  1  2  3

0     21 20 18 15
1     19 17 14 12
2     16 13 11 10

Output's element's coordinates

      23
      22 12
      21 12 03
      20 11 02
      10 11
      00
 */



