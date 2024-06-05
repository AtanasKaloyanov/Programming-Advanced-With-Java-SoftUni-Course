package T02MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        // 1. Reading matrix
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] row = readRow(scanner);
            matrix[i] = row;
        }

        // 2. Finding the diagonal's sum
        int primaryDiagSum = 0;
        for (int j = 0; j < n; j++) {
            int currentElement = matrix[j][j];
            primaryDiagSum += currentElement;
        }

        int secondaryDiagSum = 0;
        int i = n - 1;
        for (int j = 0; j < n; j++) {
            int currentElement = matrix[i][j];
            secondaryDiagSum += currentElement;
            i--;
        }

        // 3. Absolute value calculation and printing
        int difference = Math.abs(primaryDiagSum - secondaryDiagSum);
        System.out.println(difference);
    }

    private static int[] readRow(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}


