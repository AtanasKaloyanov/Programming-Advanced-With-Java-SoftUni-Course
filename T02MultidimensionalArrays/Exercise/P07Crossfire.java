package T02MultidimensionalArrays.Exercise;


import java.util.Arrays;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][columns];
        fillMatrix(matrix, columns);

        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] array = input.split(" ");
            int bombRow = Integer.parseInt(array[0]);
            int bombColumn = Integer.parseInt(array[1]);
            int radius = Integer.parseInt(array[2]);

            deletingElements(matrix, bombRow, bombColumn, radius);

            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void deletingElements(int[][] matrix, int bombRow, int bombColumn, int radius) {
        for (int row = 0; row < matrix.length; row++) {
            if (row == bombRow) {
                for (int column = Math.max(0, bombColumn - radius); column < Math.min(matrix[row].length , bombColumn + radius); column++) {
                       matrix[bombRow][column] = 0;
                }
            }
        }

        for (int i = Math.max(0, bombRow - radius); i < Math.min(matrix.length, bombRow + radius); i++) {
           if (matrix[i].length > bombColumn) {
               matrix[i][bombColumn] = 0;
           }
        }

        for (int row = 0; row < matrix.length; row++) {
            int[] currentRow = Arrays.stream(matrix[row])
                    .filter(e -> e != 0)
                    .toArray();

            matrix[row] = currentRow;
        }
    }

    private static void fillMatrix(int[][] matrix, int columns) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = number;
                number++;
            }
        }
    }
}

//   0 1 2

//0   1 2 3
//1   4 5 6
//2   7 8 9

// 00 - 1   01 - 2   02 - 3
// 10 - 4   11 - 5   12 - 6
// 20 - 7   21 - 8   22 - 9