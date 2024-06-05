package T02MultidimensionalArrays.Lab;
import java.util.Scanner;

public class P07FindTheRealQueen {
    private static char[][] matrix = new char[8][8];

    public static void main(String[] args) {
        // 1. Matrix reading
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 8; i++) {
            char[] currentRow = readMatrix(scanner);
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = currentRow[j];
            }
        }

        // 2. Searching the real queen
        boolean realQueen = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char currentElement = matrix[i][j];

                if (currentElement == 'q') {  // 3. Moving
                    realQueen = moveRight(i, j + 1); // 3.1. Right
                    if (!realQueen) {
                        break;
                    }

                    realQueen = moveRightUp(i - 1, j + 1); // 3.2. Right Up
                    if (!realQueen) {
                        continue;
                    }

                    realQueen = moveRightDown(i + 1, j + 1); // 3.3. Right Down
                    if (!realQueen) {
                        continue;
                    }

                    realQueen = moveDown(i + 1, j); // 3.4. Down
                    if (!realQueen) {
                        continue;
                    }

                    realQueen = moveLeftDown(i + 1, j - 1); // 3.5. Left Down
                    if (!realQueen) {
                        continue;
                    }

                    realQueen = moveLeftUp(i - 1, j - 1); // 3.6. Left Up
                    if (!realQueen) {
                        continue;
                    }
                }

                if (realQueen) {
                    System.out.println(i + " " + j);
                    return;
                }
            }

        }
    }

    private static boolean moveLeftUp(int i, int j) {
        while (i >= 0 && j >= 0) {
            char currentElement = matrix[i][j];
            if (currentElement == 'q') {
                return false;
            }
            i--;
            j--;
        }

        return true;
    }

    private static boolean moveLeftDown(int i, int j) {
        while (i < 8 && j >= 0) {
            char currentElement = matrix[i][j];
            if (currentElement == 'q') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean moveDown(int i, int j) {
        while (i < 8) {
            char currentElement = matrix[i][j];
            if (currentElement == 'q') {
                return false;
            }
            i++;
        }
        return true;
    }

    private static boolean moveRightDown(int i, int j) {
        while (i < 8 && j < 8) {
            char currentElement = matrix[i][j];
            if (currentElement == 'q') {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    private static boolean moveRightUp(int i, int j) {
        while (i >= 0 && j < 8) {
            char currentElement = matrix[i][j];
            if (currentElement == 'q') {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    private static boolean moveRight(int i, int j) {
        while (j < 8) {
            char currentElement = matrix[i][j];
            if (currentElement == 'q') {
                return false;
            }
            j++;
        }
        return true;
    }

    private static char[] readMatrix(Scanner scanner) {
        return scanner.nextLine()
                .replaceAll(" ", "")
                .toCharArray();
    }
}
