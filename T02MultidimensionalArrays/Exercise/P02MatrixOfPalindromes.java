package T02MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        // 1. Rows and columns reading
        Scanner scanner = new Scanner(System.in);
        int[] array = readDimensions(scanner);
        int rows = array[0];
        int columns = array[1];

        // 2. Printing rows and column symbol
        for (int i = 0; i < rows; i++) {
            char rowSymbol = (char) (i + 97);
            for (int j = 0; j < columns; j++) {
                char columnSymbol = (char) (rowSymbol + j);
                System.out.printf("%c%c%c ", rowSymbol, columnSymbol, rowSymbol);
            }
            System.out.println();
        }
    }

    private static int[] readDimensions(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
