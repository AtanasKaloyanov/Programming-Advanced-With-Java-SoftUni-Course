package T02MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotationSecondSolution {
    public static void main(String[] args) {
        // 1. Finding the rotation case. There are 3 possibilities - 0, 90, 180, 270
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        command = command.replace(")", "");
        String[] array = command.split("\\(");
        int rotationCase = Integer.parseInt(array[1]) % 360;

        // 2. Saving the elements into a list
        List<String> wordsList = new ArrayList<>();
        String longest = "";

        String currentLine = scanner.nextLine();
        while (!currentLine.equals("END")) {
            if (currentLine.length() > longest.length()) {
                longest = currentLine;
            }
            wordsList.add(currentLine);
            currentLine = scanner.nextLine();
        }

        // 3. Reading the matrix. The rows' length is the length of the longest element. The
        // columns' length is the length of number of the inputs
        int rows = wordsList.size();
        int columns = longest.length();

        char[][] matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] currentRow = wordsList.get(i).toCharArray();
            for (int j = 0; j < columns; j++) {
                if (j < currentRow.length) {
                    matrix[i][j] = currentRow[j];
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        // 4. Rotation implementation
        char[][] resultMatrix = new char[0][];
        switch (rotationCase) {
            case 0:
                resultMatrix = matrix;
                break;
            case 90:
                resultMatrix = new char[columns][rows];
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        char currentChar = matrix[rows - 1 - j][i];
                        resultMatrix[i][j] = currentChar;
                    }
                }
                break;

            case 180:
                resultMatrix = new char[rows][columns];
                int index = 0;
                for (int i = rows - 1; i >= 0; i--) {
                    char[] currentRow = matrix[i];
                    char[] reversedRow = getReversedArray(currentRow);
                    resultMatrix[index] = reversedRow;
                    index++;
                }
                break;

            case 270:
                resultMatrix = new char[columns][rows];
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        char currentChar = matrix[j][columns - 1 - i];
                        resultMatrix[i][j] = currentChar;
                    }
                }
                break;
        }

        // 5. Output printing
        if (rotationCase == 90 || rotationCase == 270) {
            printMatrix(columns, rows, resultMatrix);
        } else if (rotationCase == 0 || rotationCase == 180) {
            printMatrix(rows, columns, resultMatrix);
        }
    }

    private static char[] getReversedArray(char[] currentRow) {
        return String.valueOf(new StringBuilder(String.valueOf(currentRow)).reverse()).toCharArray();
    }

    private static void printMatrix(int rows, int columns, char[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}

/*
hello
softuni
exam

Rows - 7 (the length of the longest String)
Column - 3 (the length of the input)

     0 1 2 3 4 5 6
 0   h e l l o
 1   s o f t u n i
 2   e x a m


 Rotate(90)

      0 1 2
   0  e s h
   1  x o e
   2  a f l
   3  m t l
   4    u o
   5    n
   6    i

   Rotate(180)

       0 1 2 3 4 5 6
   0       o l l e h
   1   i n u t f o s
   2         m a x e

   Rotate(270)

       0 1 2
   0     i
   1     n
   2   o u
   3   l t m
   4   l f a
   5   e o x
   6   h s e
 */
