package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        // 1. Matrix reading
        Scanner scanner = new Scanner(System.in);
        String[] rowsAndColumns = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndColumns[0]);
        int columns = Integer.parseInt(rowsAndColumns[1]);

        int[][] matrix = new int[rows][columns];
        fillMatrix(matrix, scanner, columns);

        // 2. Best sum, best row and best column finding
        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestColumn = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int column = 0; column < columns - 2; column++) {
                int start = matrix[row][column];
                int startRightOne = matrix[row][column + 1];
                int startRightTwo = matrix[row][column + 2];
                int downOne = matrix[row + 1][column];
                int downTwo = matrix[row + 2][column];
                int diagonalOne = matrix[row + 1][column + 1];
                int diagonalTwo = matrix[row + 2][column + 2];
                int diagonalOneDown = matrix[row + 2][column + 1];
                int diagonalOneRight = matrix[row + 1][column + 2];

               int currentSum = start + startRightOne + startRightTwo + downOne + downTwo
                        + diagonalOne + diagonalTwo + diagonalOneDown + diagonalOneRight;

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestRow = row;
                    bestColumn = column;
                }
            }
        }

        // 3. Best sum and best submatrix printing
        System.out.printf("Sum = %d%n", bestSum);
        printFinalMatrix(matrix, bestRow, bestColumn);
    }

    private static void printFinalMatrix(int[][] matrix, int bestRow, int bestColumn) {
        for (int row = bestRow; row <= bestRow + 2; row++) {
            for (int column = bestColumn; column <= bestColumn + 2; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner, int columns) {
        for (int row = 0; row < matrix.length; row++) {
            String[] array = scanner.nextLine().split(" ");
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = Integer.parseInt(array[column]);
            }
        }
    }
}
