package T02MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndColumns = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndColumns[0]);
        int columns = Integer.parseInt(rowsAndColumns[1]);

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            String[] array = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }
        }
        int[][] searchedMatrix = new int[2][2];
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                int upLeft = matrix[i][j];
                int upRight = matrix[i][j + 1];
                int downLeft = matrix[i + 1][j];
                int downRight = matrix[i + 1][j + 1];
                sum = upLeft + upRight + downLeft + downRight;

                if (sum > maxSum) {
                    maxSum = sum;
                    searchedMatrix[0][0] = upLeft;
                    searchedMatrix[0][1] = upRight;
                    searchedMatrix[1][0] = downLeft;
                    searchedMatrix[1][1] = downRight;
                }
            }
        }

        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(searchedMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
        //3, 6

        //     0  1  2  3  4  5

        // 0   7, 1, 3, 3, 2, 1
        // 1   1, 3, 9, 8, 5, 6
        // 2   4, 6, 7, 9, 1, 0


        //  00 01    01 02    02 03    03 04   04 05
        //  10 11    11 12    12 13    13 14   14 15

        //  7  1     1  3     3  3     3  2    2  1
        //  1  3     3  9     9  8     8  5    5  6

        //  10 11    11 12    12 13    13 14   14 15
        //  20 21    21 22    22 23    23 24   24 25

        //  1  3     3  9     9  8     8  5    5  6
        //  4  6     6  7     7  9     9  1    1  0
    }
}
