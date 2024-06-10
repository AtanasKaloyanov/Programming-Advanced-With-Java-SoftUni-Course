package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        // 1. Dimensions reading and matrix initializations
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);
        boolean[][] matrix = new boolean[rows][columns];

        // 2. Commands implementation
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] currentInfo = input.split(" ");
            int currentStartRow = Integer.parseInt(currentInfo[0]);
            int currentFinalRow = Integer.parseInt(currentInfo[1]);
            int currentFinalColumn = Integer.parseInt(currentInfo[2]);

            // 2.1. Starting path initialization (first row distance)
            int path = (Math.abs(currentFinalRow - currentStartRow)) + 1;
            // 2.2. If the given place is free - parking, adding the row distance and printing the whole path
            if (!matrix[currentFinalRow][currentFinalColumn]) {
                matrix[currentFinalRow][currentFinalColumn] = true;
                path += currentFinalColumn;
                System.out.println(path);
            } else {
                // 2.3. In other case finding the place left or right of the given position
                int newColumn = -1;
                // 2.3.1. Travelling left
                for (int i = currentFinalColumn - 1; i >= 1; i--) {
                    if (!matrix[currentFinalRow][i]) {
                        newColumn = i;
                        break;
                    }
                }

                // 2.3.2. Travelling left
                for (int i = currentFinalColumn + 1; i < columns; i++) {
                    if (!matrix[currentFinalRow][i]) {
                        if (newColumn == -1) {
                            newColumn = i;
                        } else {
                            int distance1 = currentFinalColumn - newColumn;
                            int distance2 = i - currentFinalColumn;

                            if (distance2 < distance1) {
                                newColumn = i;
                            }
                        }

                        break;
                    }
                }
                // 2.4. When the searching is over there are 2 cases:
                // 2.4.1. If there isn't a free place - message printing
                if (newColumn == -1) {
                    System.out.printf("Row %d full\n", currentFinalRow);
                    // 2.4.2. If there is a free place - parking, adding the current distance and printing the whola path
                } else {
                    matrix[currentFinalRow][newColumn] = true;
                    path += newColumn;
                    System.out.println(path);
                }
            }

            input = scanner.nextLine();
        }
    }
}

/*
Input 1:

4 4

   0 1 2 3

0  x x x x
1  x x x x
2  x x x x
3  x x x x

1.  1 2 2 - 4

   0 1 2 3

0  x x x x
1  x x x x
2  x x C x
3  x x x x


2.  2 2 2 - 2

   0 1 2 3

0  x x x x
1  x x x x
2  x C C x
3  x x x x

3. 2 2 2 - 4

   0 1 2 3

0  x x x x
1  x x x x
2  x C C C
3  x x x x

4. 3 2 2 - Row 2 full

   0 1 2 3

0  x x x x
1  x x x x
2  x C C C
3  x x x x

Input 2:

10000 10000

      0 1 2 ... 9999
0     x x x ...  x
1     x x x ...  x
2     x x x ...  x
.     x x x ...  x
9999  x x x ...  x

1. 0 9999 9999  -  19999

      0 1 2 ... 9999
0     x x x ...  x
1     x x x ...  x
2     x x x ...  x
.     x x x ...  x
9999  x x x ...  C


2. 9999 0 9999  -  19999

      0 1 2 ... 9999
0     x x x ...  x
1     x x x ...  x
2     x x x ...  x
.     x x x ...  x
9999  x x x ...  C

 */



