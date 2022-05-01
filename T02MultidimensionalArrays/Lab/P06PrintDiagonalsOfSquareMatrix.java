package T02MultidimensionalArrays.Lab;

import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];

        for (int i = 0; i < rowsAndColumns; i++) {
            String[] array = scanner.nextLine().split(" ");
            for (int j = 0; j < rowsAndColumns; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }
        }

        for (int i = 0; i < rowsAndColumns; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();

        for (int i = 0; i < rowsAndColumns; i++) {
            System.out.print(matrix[rowsAndColumns - i - 1][i] + " ");
        }
    }
}
//1 2 3         1 2 3      00  11  22
//1 2 3         1 2 3      20  11  02
//1 2 3

