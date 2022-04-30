package T02MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int colums = Integer.parseInt(scanner.nextLine());
        String[][] firstMatrix = new String[rows][colums];

        for (int i = 0; i < rows; i++) {
            String[] array = scanner.nextLine().split(" ");
            for (int j = 0; j < colums ; j++) {
               firstMatrix[i][j] = array[j];
            }
        }

        String[][] secondMatrix = new String[rows][colums];

        for (int i = 0; i < rows; i++) {
            String[] array = scanner.nextLine().split(" ");
            for (int j = 0; j < colums ; j++) {
                secondMatrix[i][j] = array[j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])) {
                    System.out.print(firstMatrix[i][j] + " ");
                } else {
                    System.out.print('*' + " ");
                }
            }
            System.out.println();
        }
    }
}
