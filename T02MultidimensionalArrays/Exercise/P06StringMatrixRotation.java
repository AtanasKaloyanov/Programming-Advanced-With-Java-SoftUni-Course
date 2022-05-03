package T02MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int angleRotation = Integer.parseInt(rotation.split("[()]")[1]) % 360;
        String input = scanner.nextLine();

        int maxLength = Integer.MIN_VALUE;
        List<String> list = new ArrayList<>();

        while (!input.equals("END")) {
            int currentLength = input.length();

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }

            list.add(input);
            input = scanner.nextLine();
        }

        int rows = list.size();
        int columns = maxLength;
        char[][] matrix = new char[rows][columns];
        fillMatrix(matrix, columns, list);
        printMatrix(matrix, rows, columns, angleRotation);
    }

    private static void printMatrix(char[][] matrix, int rows, int columns, int angleRotation) {
        switch (angleRotation) {
            case 0:

            for (int row = 0; row < matrix.length; row++) {
                for (int column = 0; column < columns; column++) {
                    System.out.print(matrix[row][column]);
                }
                System.out.println();
            }
            break;
            
            case 90:
                for (int column = 0; column < columns ; column++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][column]);
                    }
                    System.out.println();
                }
                break;

            case 180:
                for (int row = rows - 1; row >= 0 ; row--) {
                    for (int column = columns - 1; column >= 0 ; column--) {
                        System.out.print(matrix[row][column]);
                    }
                    System.out.println();
                }
                break;

            case 270:
                for (int column = columns - 1; column >= 0 ; column--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][column]);
                    }
                    System.out.println();
                }
                break;
        }
        }
    

    private static void fillMatrix(char[][] matrix, int columns, List<String> list) {
        for (int row = 0; row < matrix.length; row++) {
            String currentString = list.get(row);
            for (int column = 0; column < columns ; column++) {
                if (column < currentString.length()) {
                    char currentChar = currentString.charAt(column);
                    matrix[row][column] = currentChar;
                } else {
                    matrix[row][column] = ' ';
                }
            }
        }
    }
}

//    0 1 2 3 4 5 6

//0   h e l l o
//1   s o f t u n i
//2   e x a m

// 00 - h   01 - e   02 - l   03 - l   04 - o   05 -    06 -
// 10 - s   11 - o   12 - f   13 - t   14 - u   15 - n  16 - i
// 20 - e   21 - x   22 - a   23 - m   24 -     25 -    26 -

//     0 1 2
//0    e s h
//1    x o e
//2    a f l
//3    m t l
//4      u o
//5      n
//6      i

// 00 - e   01 - s   02 - h
// 10 - x   11 - o   12 - e
// 20 - a   21 - f   22 - l
// 30 - m   31 - t   32 - l
// 40 -     41 - u   42 - o
// 50 -     51 - n   52 -
// 60 -     61 - i   62 -