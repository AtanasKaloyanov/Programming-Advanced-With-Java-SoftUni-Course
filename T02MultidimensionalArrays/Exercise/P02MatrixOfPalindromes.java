package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][columns];

        fillMatrix(matrix, scanner, columns);

        printMatrix(matrix, scanner, columns);
    }

    private static void printMatrix(String[][] matrix, Scanner scanner, int columns) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner, int columns) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < columns; column++) {
                char firstChar = (char) (97 + row);
                char secondChar = (char) (97 + column + row);
                char thirdChar = (char) (97 + row);
                StringBuilder sb = new StringBuilder();
                sb.append(firstChar);
                sb.append(secondChar);
                sb.append(thirdChar);
                matrix[row][column] = sb.toString();
            }
        }
    }
}
