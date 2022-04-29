package T02MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArray = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(inputArray[0]);
        int columns = Integer.parseInt(inputArray[1]);

        int sum = 0;

        for (int i = 0; i < rows; i++) {
                String[] array = scanner.nextLine().split(", ");
            for (int j = 0; j < columns; j++) {
                int currentElement = Integer.parseInt(array[j]);
                sum += currentElement;
            }
        }
        System.out.println(rows);
        System.out.println(columns);
        System.out.println(sum);
    }
}
