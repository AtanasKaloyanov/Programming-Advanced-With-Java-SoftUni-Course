package T02MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        int firstMatrixRows = Integer.parseInt(firstInput[0]);
        int firstMatrixColums = Integer.parseInt(firstInput[1]);

        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixColums];

        for (int i = 0; i < firstMatrixRows; i++) {
            int[] firstArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            for (int j = 0; j < firstMatrixColums; j++) {
                firstMatrix[i][j] = firstArray[j];
            }
        }

        String[] secondInput = scanner.nextLine().split(" ");
        int secondMtrixRows = Integer.parseInt(secondInput[0]);
        int secondMatrixColums = Integer.parseInt(secondInput[1]);

        if (firstMatrixRows != secondMtrixRows || firstMatrixColums != secondMatrixColums) {
            System.out.println("not equal");
            return;
        }

        int[][] secondMatrix = new int[secondMtrixRows][secondMatrixColums];

        for (int i = 0; i < secondMtrixRows; i++) {
            int[] secondArray = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();

            for (int j = 0; j < secondMatrixColums; j++) {
                secondMatrix[i][j] = secondArray[j];
            }
        }

        boolean notEquals = false;

            for (int i = 0; i < firstMatrixRows; i++) {
                for (int j = 0; j < firstMatrixColums; j++) {
                    int currentFirstMatrix = firstMatrix[i][j];
                    int currentSecondMatrix = secondMatrix[i][j];

                    if (currentFirstMatrix != currentSecondMatrix) {
                        notEquals = true;
                        break;
                    }
                }
                if (notEquals) {
                    break;
                }
            }

if (notEquals) {
    System.out.println("not equal");
} else {
    System.out.println("equal");
}
    }
}
