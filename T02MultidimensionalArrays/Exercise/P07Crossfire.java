package T02MultidimensionalArrays.Exercise;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String[] coordinates = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(coordinates[0]);
        int columns = Integer.parseInt(coordinates[1]);

        // 2. Matrix filling
        List<List<Integer>> matrix = fillingMatrix(rows, columns);

        // 3. Removing elements until a command
        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] elements = input.split(" ");
            int bombRow = Integer.parseInt(elements[0]);
            int bombColumn = Integer.parseInt(elements[1]);
            int bombRadius = Integer.parseInt(elements[2]);

            for (int i = 0; i < matrix.size(); i++) {
                List<Integer> currentRow = matrix.get(i);

                // 3.1. Borders of the elements that should be removed finding
                int startRow = Math.max(0, bombRow - bombRadius);
                int endRow = Math.min(matrix.size() - 1, bombRow + bombRadius);
                int startColumn = Math.max(0, bombColumn - bombRadius);
                int endColumn = Math.min(currentRow.size() - 1, bombColumn + bombRadius);

                for (int j = currentRow.size() - 1; j >= 0; j--) {
                    int currentElement = currentRow.get(j); // The current element can be seen by debugging
                    // 3.2. Removing the element if it is between the borders
                    if ((i == bombRow && j >= startColumn && j <= endColumn) ||
                            (j == bombColumn && i >= startRow && i <= endRow)) {
                        currentRow.remove(j);
                    }
                }

                // 3.3. Adding the row with the remaining elements
                matrix.set(i, currentRow);
            }

            // 3.2. Removing the empty rows
            matrix.removeIf((el) -> el.size() == 0);
            input = scanner.nextLine();
        }

        // 4. Matrix printing
        matrixPrinting(matrix);
    }

    private static void matrixPrinting(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            String currentRow = toStringRow(matrix, i);
            System.out.println(currentRow);
        }
    }

    private static String toStringRow(List<List<Integer>> matrix, int i) {
        return matrix.get(i).toString().replaceAll("[\\[\\],]", "");
    }

    private static List<List<Integer>> fillingMatrix(int rows, int columns) {
        List<List<Integer>> matrix = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> currentArray = new ArrayList<>();
            for (int j = 0; j < columns; j++) {
                currentArray.add(number);
                number++;
            }
            matrix.add(currentArray);
        }
        return matrix;
    }
}

/*
Input 1:
5 5

     0  1  2  3  4

0    1  2  3  4  5
1    6  7  8  9  10
2    11 12 13 14 15
3    16 17 18 19 20
4    21 22 23 24 25

1. 3 3 2

     0  1  2  3  4

0    1  2  3  4  5
1    6  7  8  10
2    11 12 13 15
3    16
4    21 22 23 25

2. 4 3 2

     0  1  2  3  4

0    1  2  3  4  5
1    6  7  8  10
2    11 12 13
3    16
4    21

// Input 3:

2 2

      0   1
0     1   2
1     3   4

1. 1 1 3

      0
0     1

2.   0 0 1

// Input 4:

5 5

       0  1  2  3  4

0      1  2  3  4  5
1      6  7  8  9  10
2      11 12 13 14 15
3      16 17 18 19 20
4      21 22 23 24 25

1. 2 3 3

      0  1  2  3

0     1  2  3  5
1     6  7  8  10
2     16 17 18 20
3     21 22 23 25

// Input 5

6 2

      0  1

0     1  2
1     3  4
2     5  6
3     7  8
4     9  10
5     11 12

1 1 2

      0  1

0     1
1     5
2     7
3     9  10
4     11 12

1 1 2

     0  1

0    1
1    7
2    9
3    11 12
 */


