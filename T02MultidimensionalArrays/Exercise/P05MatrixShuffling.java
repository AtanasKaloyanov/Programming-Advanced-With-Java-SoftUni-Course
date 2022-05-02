package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndColumns = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndColumns[0]);
        int columns = Integer.parseInt(rowsAndColumns[1]);

        String[][] matrix = new String[rows][columns];

        fillMatrix(matrix, scanner, columns);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] array = input.split(" ");

            if (array.length != 5) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String command = array[0];

            if (!command.equals("swap")) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            } else {
                int oldRow = Integer.parseInt(array[1]);
                int oldColumn = Integer.parseInt(array[2]);
                int newRow = Integer.parseInt(array[3]);
                int newColumn = Integer.parseInt(array[4]);

                if ((oldRow < 0 || oldRow > rows - 1) || (oldColumn < 0 || oldColumn > columns - 1)
                    || (newRow < 0 || newRow > rows - 1) || (newColumn < 0 || newColumn > columns - 1)) {
                    System.out.println("Invalid input!");
                    input = scanner.nextLine();
                    continue;
                } else {
                    String oldElement = matrix[oldRow][oldColumn];
                    String newElement = matrix[newRow][newColumn];
                    matrix[oldRow][oldColumn]  = newElement;
                    matrix[newRow][newColumn] = oldElement;

                    print(matrix, scanner, columns);
                }
            }

            input = scanner.nextLine();
        }

    }

    private static void print(String[][] matrix, Scanner scanner, int columns) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner, int columns) {
        for (int row = 0; row < matrix.length; row++) {
            String[] array = scanner.nextLine().split(" ");
            for (int column = 0; column < columns; column++) {
                matrix[row][column] = array[column];
            }
        }
    }
}
