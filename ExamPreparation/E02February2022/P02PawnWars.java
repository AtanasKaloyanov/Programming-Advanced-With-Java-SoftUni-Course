package T11ExamPreparation.E02February2022;

import java.util.Scanner;

public class P02PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        int whiteRow = 0;
        int whiteColumn = 0;
        int blackRow = 0;
        int blackColumn = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'w') {
                    whiteRow = i;
                    whiteColumn = j;
                } else if (currentChar == 'b') {
                    blackRow = i;
                    blackColumn = j;
                }
            }
        }

        boolean isCaptured = false;
        char realColumn = 0;
        int realRow = 0;

        while (whiteRow != 0 && blackRow != 7) {
            if (isHit(blackColumn, whiteColumn, blackRow, whiteRow)) {
                isCaptured = true;
                whiteRow = blackRow;
                whiteColumn = blackColumn;

                realColumn = setColumn(blackColumn, realColumn);
                realRow = setRow(whiteRow, realRow);

                System.out.printf("Game over! White capture on %c%d.", realColumn, realRow);
                break;

            } else {
                matrix[whiteRow][whiteColumn] = '-';
                whiteRow--;
            }

            if (isHit(blackColumn, whiteColumn, blackRow, whiteRow)) {
                isCaptured = true;
                blackRow = whiteRow;
                blackColumn = whiteColumn;

                realColumn = setColumn(blackColumn, realColumn);
                realRow = setRow(whiteRow, realRow);

                System.out.printf("Game over! Black capture on %c%d.", realColumn, realRow);
                break;
            } else {
                matrix[blackRow][blackColumn] = '-';
                blackRow++;
            }
        }

        if (!isCaptured) {
            if (whiteRow == 0) {

                realColumn = setColumn(whiteColumn, realColumn);
                realRow = 8;

                System.out.printf("Game over! White pawn is promoted to a queen at %c%d.", realColumn, realRow);
            } else if (blackRow == 7) {

                realColumn = setColumn(blackColumn, realColumn);
                realRow = 1;

                System.out.printf("Game over! Black pawn is promoted to a queen at %c%d.", realColumn, realRow);
            }
        }
    }

    public static boolean isHit(int blackColumn, int whiteColumn, int blackRow, int whiteRow) {
        return ((blackColumn == whiteColumn - 1 || blackColumn == whiteColumn + 1) && blackRow == whiteRow - 1);
    }

    public static char setColumn(int currentColumn, char realColumn) {
        if (currentColumn == 0) {
            realColumn = 'a';
        } else if (currentColumn == 1) {
            realColumn = 'b';
        } else if (currentColumn == 2) {
            realColumn = 'c';
        } else if (currentColumn == 3) {
            realColumn = 'd';
        } else if (currentColumn == 4) {
            realColumn = 'e';
        } else if (currentColumn == 5) {
            realColumn = 'f';
        } else if (currentColumn == 6) {
            realColumn = 'g';
        } else if (currentColumn == 7) {
            realColumn = 'h';
        }
        return realColumn;
    }

    public static int setRow(int currentRow, int realRow) {
        if (currentRow == 0) {
            realRow = 8;
        } else if (currentRow == 1) {
            realRow = 7;
        } else if (currentRow == 2) {
            realRow = 6;
        } else if (currentRow == 3) {
            realRow = 5;
        } else if (currentRow == 4) {
            realRow = 4;
        } else if (currentRow == 5) {
            realRow = 3;
        } else if (currentRow == 6) {
            realRow = 2;
        } else if (currentRow == 7) {
            realRow = 1;
        }
        return realRow;
    }
}
