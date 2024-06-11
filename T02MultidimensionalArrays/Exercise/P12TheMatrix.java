package T02MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P12TheMatrix {
    private static char[][] matrix;
    private static int matrixRows;
    private static int matrixColumns;
    private static char fillingElement;
    private static int currentRow;
    private static int currentColumn;
    private static char replacementElement;

    public static void main(String[] args) {
        // 1. Matrix initialization
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        matrixRows = Integer.parseInt(dimensions[0]);
        matrixColumns = Integer.parseInt(dimensions[1]);
        matrix = matrixInitialization(matrixRows, matrixColumns, scanner);

        // 2. Filling element and starting dimensions reading
        fillingElement = scanner.nextLine().toCharArray()[0];
        String[] array = scanner.nextLine().split(" ");
        currentRow = Integer.parseInt(array[0]);
        currentColumn = Integer.parseInt(array[1]);
        replacementElement = matrix[currentRow][currentColumn];

        // 3. Moving recursively
        moving(currentRow, currentColumn);

        // 4. Matrix printing
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixColumns; j++) {
                char currentElement = matrix[i][j];
                System.out.print(currentElement);
            }
            System.out.println();
        }
    }

    private static void moving(int currentRow, int currentColumn) {
        if (!isTheRowInBounds(currentRow) || !isTheColumnInBounds(currentColumn)) {
            return;
        }
        char currentElement = matrix[currentRow][currentColumn];
        if (currentElement != replacementElement) {
            return;
        }

        matrix[currentRow][currentColumn] = fillingElement;

        // left
        moving(currentRow, currentColumn - 1);
        // up
        moving(currentRow - 1, currentColumn);
        // right
        moving(currentRow, currentColumn + 1);
        // down
        moving(currentRow + 1, currentColumn);
    }

    private static boolean isTheColumnInBounds(int currentColumn) {
        return currentColumn >= 0 && currentColumn < matrixColumns;
    }

    private static boolean isTheRowInBounds(int currentRow) {
        return currentRow >= 0 && currentRow < matrixRows;
    }

    private static char[][] matrixInitialization(int rows, int columns, Scanner scanner) {
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            char[] currentRow = readLine(scanner);
            matrix[i] = currentRow;
        }
        return matrix;
    }

    private static char[] readLine(Scanner scanner) {
        return Arrays.toString(scanner.nextLine().split(" "))
                .replaceAll("[\\[\\], ]", "")
                .toCharArray();
    }
}

