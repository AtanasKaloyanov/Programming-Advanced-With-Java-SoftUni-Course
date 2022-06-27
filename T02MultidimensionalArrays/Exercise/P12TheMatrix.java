package T02MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndColumns = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndColumns[0]);
        int columns = Integer.parseInt(rowsAndColumns[1]);

        char[][] matrix = new char[rows][columns];
        createMatrix(matrix, rows, scanner);

        char replaceChar = scanner.nextLine().charAt(0);

        String[] startPositions = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(startPositions[0]);
        int startColumn = Integer.parseInt(startPositions[1]);

        char startSymbol = matrix[startRow][startColumn];
        fillMatrixWithGivenChar(startRow, startColumn, replaceChar, startSymbol, matrix);

        printMatrix(matrix);

    }

    private static void fillMatrixWithGivenChar(int startRow, int startColumn, char replaceChar, char startChar, char[][] matrix) {
        if (matrix[startRow][startColumn] != startChar) {
            return;
        }

        matrix[startRow][startColumn] = replaceChar;
        if (startRow - 1 >= 0) {
            fillMatrixWithGivenChar(startRow - 1, startColumn, replaceChar, startChar, matrix);
        }

        if (startRow + 1 < matrix.length) {
            fillMatrixWithGivenChar(startRow + 1, startColumn, replaceChar, startChar, matrix);
        }

        if (startColumn - 1 >= 0) {
            fillMatrixWithGivenChar(startRow, startColumn - 1, replaceChar, startChar, matrix);
        }

        if (startColumn + 1 < matrix[startRow].length) {
            fillMatrixWithGivenChar(startRow, startColumn + 1, replaceChar, startChar, matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
    }

    private static void createMatrix(char[][] matrix, int rows, Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            String[] inputArray = scanner.nextLine().split("\\s+");
            for (int column = 0; column < inputArray.length; column++) {
                char currentChar = inputArray[column].charAt(0);
                matrix[row][column] = currentChar;
            }
        }
    }

}
