package T02MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        // 1. Matrix reading
        Scanner scanner = new Scanner(System.in);
        List<String> dimension = readList(scanner);
        int rows = Integer.parseInt(dimension.get(0));
        int columns = Integer.parseInt(dimension.get(1));

        List<List<String>> matrix = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<String> currentRow = readList(scanner);
            matrix.add(currentRow);
        }

        // 2. Swap commands implementation
        String currentLine = scanner.nextLine();
        while (!currentLine.equals("END")) {
            // 2.1. Data validation and reading
            String[] currentArray = currentLine.split(" ");
            if (currentArray.length != 5) {
                System.out.println("Invalid input!");
                currentLine = scanner.nextLine();
                continue;
            }

            String command = currentArray[0];
            int el1row = Integer.parseInt(currentArray[1]);
            int el1column = Integer.parseInt(currentArray[2]);
            int el2row = Integer.parseInt(currentArray[3]);
            int el2column = Integer.parseInt(currentArray[4]);

            if (!areCoordAndCommandValid(rows, columns, command, el1row, el1column, el2row, el2column)) {
                System.out.println("Invalid input!");
                currentLine = scanner.nextLine();
                continue;
            }

            // 2.2. Elements getting and swapping
            List<String> row1 = matrix.get(el1row);
            String el1 = row1.get(el1column);
            List<String> row2 = matrix.get(el2row);
            String el2 = row2.get(el2column);

            matrix.get(el1row).set(el1column, el2);
            matrix.get(el2row).set(el2column, el1);

            // 2.3. The changed matrix printing
            for (int i = 0; i < rows; i++) {
                List<String> currentRow = matrix.get(i);
                for (int j = 0; j < columns; j++) {
                    System.out.print(currentRow.get(j) + " ");
                }
                System.out.println();
            }

            currentLine = scanner.nextLine();
        }
    }

    private static boolean areCoordAndCommandValid(int rows, int columns, String command, int el1row, int el1column, int el2row, int el2column) {
        return !command.equals("swap") ||
                isCooordValid(el1row, rows) || isCooordValid(el1column, columns) ||
                isCooordValid(el2row, rows) || isCooordValid(el2column, columns);
    }

    private static boolean isCooordValid(int coordinate, int coordinates) {
        if (coordinate >= 0 && coordinate < coordinates) {
            return true;
        }
        return false;
    }

    private static List<String> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
    }
}

/*
Input 1:
1 2 3
4 5 6

1. swap 0 0 1 1

5 2 3
4 1 6

2. swap 10 9 8 7

Invalid input!

3. swap 0 1 1 0

5 4 3
2 1 6

Input 2:
Hello Word

1. 0 0 0 1
Invalid Input

2. swap 0 0 0 1
World Hello

3. swap 0 1 0 0
Hello World
 */