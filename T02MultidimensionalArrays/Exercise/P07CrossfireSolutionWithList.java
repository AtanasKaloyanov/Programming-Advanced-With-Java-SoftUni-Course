package T02MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07CrossfireSolutionWithList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(matrix, rows, columns);

        String line = scanner.nextLine();

        while (!line.equals("Nuke it from orbit")) {
            String[] data = line.split(" ");

            int bombRow = Integer.parseInt(data[0]);
            int bombColumn = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int row = bombRow - radius; row <= bombRow + radius; row++) {
                if (row >= 0 && row < matrix.size() && bombColumn >= 0 && bombColumn < matrix.get(row).size() && row != bombRow) {
                    matrix.get(row).remove(bombColumn);
                }
            }

            for (int column = bombColumn + radius; column >= bombColumn - radius; column--) {
                if (bombRow >= 0 && bombRow < matrix.size() && column >= 0 && column < matrix.get(bombRow).size()) {
                    matrix.get(bombRow).remove(column);
                }
            }

            matrix.removeIf(List::isEmpty);
            line = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> currentList: matrix) {
            for (int currentInt: currentList) {
                System.out.print(currentInt + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int columns) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int column = 0; column < columns; column++) {
                matrix.get(row).add(number);
                number++;
            }
        }
    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}


