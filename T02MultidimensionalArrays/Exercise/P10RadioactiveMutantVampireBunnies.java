package T02MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P10RadioactiveMutantVampireBunnies {
    private static int playerRow;
    private static int playerColumn;
    private static char[][] matrix;

    public static void main(String[] args) {
        // 1. Matrix dimensions reading
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(array[0]);
        int columns = Integer.parseInt(array[1]);

        // 2. Matrix initialization and player's row and player's column finding
        matrix = matrixInitialization(rows, columns, scanner);

        // 3. Array with directions reading
        boolean playerWins = false;
        boolean playerLoses = false;

        char[] directions = scanner.nextLine().toCharArray();

        // 4. Moving direction by direction
        for (char direction : directions) {
            matrix[playerRow][playerColumn] = '.';

            switch (direction) {
                case 'L':
                    if (playerColumn == 0) {
                        playerWins = true;
                        break;
                    }

                    playerColumn--;
                    playerLoses = hasPlayerLost();
                    break;

                case 'U':
                    if (playerRow == 0) {
                        playerWins = true;
                        break;
                    }

                    playerRow--;
                    playerLoses = hasPlayerLost();
                    break;

                case 'R':
                    if (playerColumn == columns - 1) {
                        playerWins = true;
                        break;
                    }

                    playerColumn++;
                    playerLoses = hasPlayerLost();
                    break;

                case 'D':
                    if (playerRow == rows - 1) {
                        playerWins = true;
                        break;
                    }

                    playerRow++;
                    playerLoses = hasPlayerLost();
                    break;
            }

            // 5. Bunnies spreading and mutating
            playerLoses = vampiresSpreading(playerLoses);
            vampireMutating();

            if (playerWins || playerLoses) {
                break;
            }
        }

        // 6. Matrix printing
        for (int i = 0; i < matrix.length; i++) {
            char[] currentRow = matrix[i];
            System.out.println(currentRow);
        }

        String wonOrDead = playerWins ? "won" : "dead";
        System.out.printf("%s: %d %d", wonOrDead, playerRow, playerColumn);
    }

    private static void vampireMutating() {
        for (int i = 0; i < matrix.length; i++) {
            char[] currentRow = matrix[i];
            for (int j = 0; j < currentRow.length; j++) {
                char currentElement = matrix[i][j];
                if (currentElement == 'b') {
                    matrix[i][j] = 'B';
                }
            }
        }
    }

    private static boolean vampiresSpreading(boolean playerLoses) {
        for (int i = 0; i < matrix.length; i++) {
            char[] currentRow = matrix[i];
            for (int j = 0; j < currentRow.length; j++) {
                char currentElement = currentRow[j];
                if (currentElement == 'B') {
                    // left
                    if (j != 0) {
                        if (matrix[i][j - 1] == 'P') {
                            playerLoses = true;
                        }

                        if (matrix[i][j - 1] != 'B') {
                            matrix[i][j - 1] = 'b';
                        }
                    }

                    // up
                    if (i != 0) {
                        if (matrix[i - 1][j] == 'P') {
                            playerLoses = true;
                        }

                        if (matrix[i - 1][j] != 'B') {
                            matrix[i - 1][j] = 'b';
                        }
                    }

                    // right
                    if (j != currentRow.length - 1) {
                        if (matrix[i][j + 1] == 'P') {
                            playerLoses = true;
                        }

                        if (matrix[i][j + 1] != 'B') {
                            matrix[i][j + 1] = 'b';
                        }
                    }

                    // down
                    if (i != matrix.length - 1) {
                        if (matrix[i + 1][j] == 'P') {
                            playerLoses = true;
                        }

                        if (matrix[i + 1][j] != 'B') {
                            matrix[i + 1][j] = 'b';
                        }
                    }
                }
            }
        }

        return playerLoses;
    }

    private static boolean hasPlayerLost() {
        if (matrix[playerRow][playerColumn] == 'B') {
            return true;
        }

        matrix[playerRow][playerColumn] = 'P';
        return false;
    }

    private static char[][] matrixInitialization(int rows, int columns, Scanner scanner) {
        char[][] matrix = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = currentRow[j];

                char currentElement = currentRow[j];
                if (currentElement == 'P') {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }

        return matrix;
    }
}

/*
Input 1:

5 8

    0 1 2 3 4 5 6 7

0   . . . . . . . B
1   . . . B . . . .
2   . . . . B . . .
3   . . . . . . . .
4   . . P . . . . .

1. U

   0 1 2 3 4 5 6 7

0   . . . B . . B B
1   . . B B B . . B
2   . . . B B B . .
3   . . P . B . . .
4   . . . . . . . .

2. L

   0 1 2 3 4 5 6 7

0   . . B B B B B B
1   . B B B B b B B
2   . . B B B B B B
3   . L . B B B . .
4   . . . . . . . .

3. L

   0 1 2 3 4 5 6 7

0   . B B B B B B B
1   B B B B B b B B
2   . B B B B B B B
3   L . B B B B B B
4   . . . B B B . .

4. L

   0 1 2 3 4 5 6 7

0   B B B B B B B B
1   B B B B B B B B
2   B B B B B B B B
3   . B B B B B B B
4   . . B B B B B B

    The player escapes. His last row was 3 and his last column 0

Input 2:

4 5

    0 1 2 3 4

0   . . . . .
1   . . . . .
2   . B . . .
3   . . . P .

1. L

    0 1 2 3 4

0   . . . . .
1   . B . . .
2   B B B . .
3   . B P . .

2.  L

    0 1 2 3 4

0   . B . . .
1   B B B . .
2   B B B B .
3   B B B .

The player dies after he moves on position 3 1.

 */
