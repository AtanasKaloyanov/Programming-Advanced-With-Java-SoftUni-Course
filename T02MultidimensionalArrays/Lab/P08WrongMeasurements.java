package T02MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = 0;
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            columns = array.length;
            matrix[i] = array;
        }

        String[] wrongElementData = scanner.nextLine().split(" ");
        int wronElementRow = Integer.parseInt(wrongElementData[0]);
        int wronElementColumn = Integer.parseInt(wrongElementData[1]);
        int wrongElement = matrix[wronElementRow][wronElementColumn];

        int[][] finalMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int currentElement = matrix[i][j];
                if (currentElement == wrongElement) {
                    int sum = 0;

                    if (i > 0) {
                        int upElement = matrix[i - 1][j];
                        if (upElement != wrongElement) {
                            sum += upElement;
                        }
                    }

                    if (i < rows - 1) {
                        int downElement = matrix[i + 1][j];
                        if (downElement != wrongElement) {
                            sum += downElement;
                        }
                    }

                    if (j > 0) {
                        int leftElement = matrix[i][j - 1];
                        if (leftElement != wrongElement) {
                            sum += leftElement;
                        }
                    }

                    if (j < columns - 1) {
                        int rigthElement = matrix[i][j + 1];
                        if (rigthElement != wrongElement) {
                            sum += rigthElement;
                        }
                    }

                    finalMatrix[i][j] = sum;
                } else {
                    finalMatrix[i][j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(finalMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
