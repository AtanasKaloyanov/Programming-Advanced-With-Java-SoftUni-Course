package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        // 1. Dimensions and pattern reading
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(", ");
        int rowsAndColumns = Integer.parseInt(array[0]);
        String pattern = array[1];
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];

        // 2. 2 patterns means 2 cases:
        if (pattern.equals("A")) {
            fillingMatrixWithPatterA(matrix);

        } else if (pattern.equals("B")) {
            fillingMatrixWithPatterB(matrix);
        }

        // 3. Output printing
        prntMatrix(matrix);
    }


    private static void fillingMatrixWithPatterA(int[][] matrix) {
        int number = 1;
        for (int columns = 0; columns < matrix.length; columns++) {
            for (int rows = 0; rows < matrix.length; rows++) {
                matrix[rows][columns] = number;
                number++;
            }
        }
    }

    private static void fillingMatrixWithPatterB(int[][] matrix) {
        int number = 1;
        for (int columns = 0; columns < matrix.length; columns++) {
            if (columns % 2 == 0) {
                for (int rows = 0; rows < matrix.length; rows++) {
                  matrix[rows][columns] = number;
                  number++;
                }
            } else {
                for (int rows = matrix.length - 1; rows >= 0; rows--) {
                    matrix[rows][columns] = number;
                    number++;
                }

            }
        }
    }

    private static void prntMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int columns = 0; columns < matrix.length; columns++) {
                System.out.print(matrix[rows][columns] + " ");
            }
            System.out.println();
        }
    }
}


//         0  1  2  3

// 0       1  5  9  13
// 1       2  6  10 14
// 2       3  7  11 15
// 3       4  8  12 16

// 00 - 1      01 - 5     02 - 9      03 - 13
// 10 - 2      11 - 6     21 - 10     31 - 14
// 20 - 3      21 - 7     22 - 11     23 - 15
// 30 - 4      31 - 8     32 - 12     33 - 16

//         0  1  2  3

// 0       1  8  9  16
// 1       2  7  10 15
// 2       3  6  11 14
// 3       4  5  12 13

// 00 - 1      01 - 8     02 - 9      03 - 16
// 10 - 2      11 - 7     21 - 10     31 - 15
// 20 - 3      21 - 6     22 - 11     23 - 14
// 30 - 4      31 - 5     32 - 12     33 - 13