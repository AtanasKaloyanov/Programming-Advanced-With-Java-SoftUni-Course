package T02MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        // 1. Dimensions reading and printing
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int columns = dimensions[1];
        System.out.println(rows);
        System.out.println(columns);

        // 2. Reading of arrays that are equal to the rows
        int totalSum = 0;
        for (int i = 0; i < rows; i++) {
            int[] array = readArray(scanner);
            int currentSum = Arrays.stream(array).sum();
            totalSum += currentSum;
        }

        // 3. Printing of the total sum
        System.out.println(totalSum);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
