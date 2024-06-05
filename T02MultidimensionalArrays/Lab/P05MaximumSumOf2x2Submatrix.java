package T02MultidimensionalArrays.Lab;


import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int columns = dimensions[1];

        // 2. Matrix reading
        int[][] matrix = new int[rows][columns];
        readMatrix(scanner, rows, columns, matrix);

        // 3. Finding the best elements and sum
        int bestSum = Integer.MIN_VALUE;
        int bestCurrent = Integer.MIN_VALUE;
        int bestRight = Integer.MIN_VALUE;
        int bestDown = Integer.MIN_VALUE;
        int bestDownRight = Integer.MIN_VALUE;
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < columns - 1; j++) {
                int current = matrix[i][j];
                int right = matrix[i][j + 1];
                int down = matrix[i + 1][j];
                int downRight = matrix[i + 1][j + 1];
                int currentSum = current + right + down + downRight;
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestCurrent = current;
                    bestRight = right;
                    bestDown = down;
                    bestDownRight = downRight;
                }
            }
        }

        // 4. Best elements and sum printing
        System.out.println(bestCurrent + " " + bestRight);
        System.out.println(bestDown + " " + bestDownRight);
        System.out.println(bestSum);
    }

    private static void readMatrix(Scanner scanner, int rows, int columns, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            int[] currentArray = readArray(scanner);
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = currentArray[j];
            }
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
