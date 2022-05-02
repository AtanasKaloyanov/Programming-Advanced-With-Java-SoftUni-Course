package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];

        fillingMatrix(matrix, scanner);

        int primaryDiagonalSum = 0;
        for (int row = 0; row < rowsAndColumns; row++) {
           int currentElement = matrix[row][row];
            primaryDiagonalSum += currentElement;
        }

        int secondaryDiagonalSum = 0;
        for (int row = 0; row < rowsAndColumns; row++) {
           secondaryDiagonalSum += matrix[row][rowsAndColumns - row - 1];
        }

        int sum = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        System.out.println(sum);
    }

    private static void fillingMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] array = scanner.nextLine().split(" ");
            for (int column = 0; column < matrix.length; column++) {
                int currentElement = Integer.parseInt(array[column]);
                matrix[row][column] = currentElement;
            }
        }
    }
}

//         0   1  2

// 0       11  2  4
// 1       4   5  6
// 2       10  8 -12


// 00 - 11      01 - 2     02 - 4
// 10 - 4       11 - 5     21 - 6
// 20 - 10      21 - 8     22 - 12

//primary diagonal - 00 - 11    11 - 5   22  - -12

//secondary diagonal- 02 - 4    11 - 5   20  -  10
