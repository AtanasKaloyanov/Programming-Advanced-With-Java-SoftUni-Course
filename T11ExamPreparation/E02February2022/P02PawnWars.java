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

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'w') {
                    whiteRow = i;
                    whiteColumn = j;
                }
            }
        }

        int blackRow = 0;
        int blackColumn = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'b') {
                    blackRow = i;
                    blackColumn = j;
                }
            }
        }

        boolean isCaptured = false;
        char realColumn = 0;
        int realRow = 0;

        while (whiteRow != 0 && blackRow != 7) {
            if ((blackColumn == whiteColumn - 1 || blackColumn == whiteColumn + 1) && blackRow == whiteRow - 1) {
                isCaptured = true;
                whiteRow = blackRow;
                whiteColumn = blackColumn;

                if (whiteColumn == 0) {
                    realColumn = 'a';
                } else if (whiteColumn == 1) {
                    realColumn = 'b';
                } else if (whiteColumn == 2) {
                    realColumn = 'c';
                } else if (whiteColumn == 3) {
                    realColumn = 'd';
                } else if (whiteColumn == 4) {
                    realColumn = 'e';
                } else if (whiteColumn == 5) {
                    realColumn = 'f';
                } else if (whiteColumn == 6) {
                    realColumn = 'g';
                } else if (whiteColumn == 7) {
                    realColumn = 'h';
                }

                if (whiteRow == 0) {
                    realRow = 8;
                } else if (whiteRow == 1) {
                    realRow = 7;
                } else if (whiteRow == 2) {
                    realRow = 6;
                } else if (whiteRow == 3) {
                    realRow = 5;
                } else if (whiteRow == 4) {
                    realRow = 4;
                } else if (whiteRow == 5) {
                    realRow = 3;
                } else if (whiteRow == 6) {
                    realRow = 2;
                } else if (whiteRow == 7) {
                    realRow = 1;
                }

                System.out.printf("Game over! White capture on %c%d.", realColumn, realRow);
                break;

            } else {
                matrix[whiteRow][whiteColumn] = '-';
                whiteRow--;
            }

            if ((blackColumn == whiteColumn - 1 || blackColumn == whiteColumn + 1) && blackRow == whiteRow - 1) {
                isCaptured = true;
                blackRow = whiteRow;
                blackColumn = whiteColumn;

                if (blackColumn == 0) {
                    realColumn = 'a';
                } else if (blackColumn == 1) {
                    realColumn = 'b';
                } else if (blackColumn == 2) {
                    realColumn = 'c';
                } else if (blackColumn == 3) {
                    realColumn = 'd';
                } else if (blackColumn == 4) {
                    realColumn = 'e';
                } else if (blackColumn == 5) {
                    realColumn = 'f';
                } else if (blackColumn == 6) {
                    realColumn = 'g';
                } else if (blackColumn == 7) {
                    realColumn = 'h';
                }

                if (blackRow == 0) {
                    realRow = 8;
                } else if (blackRow == 1) {
                    realRow = 7;
                } else if (blackRow == 2) {
                    realRow = 6;
                } else if (blackRow == 3) {
                    realRow = 5;
                } else if (blackRow == 4) {
                    realRow = 4;
                } else if (blackRow == 5) {
                    realRow = 3;
                } else if (blackRow == 6) {
                    realRow = 2;
                } else if (blackRow == 7) {
                    realRow = 1;
                }

                System.out.printf("Game over! Black capture on %c%d.", realColumn, realRow);
                break;
            } else {
                matrix[blackRow][blackColumn] = '-';
                blackRow++;
            }


        }

        if (!isCaptured) {
            if (whiteRow == 0) {

                if (whiteColumn == 0) {
                    realColumn = 'a';
                } else if (whiteColumn == 1) {
                    realColumn = 'b';
                } else if (whiteColumn == 2) {
                    realColumn = 'c';
                } else if (whiteColumn == 3) {
                    realColumn = 'd';
                } else if (whiteColumn == 4) {
                    realColumn = 'e';
                } else if (whiteColumn == 5) {
                    realColumn = 'f';
                } else if (whiteColumn == 6) {
                    realColumn = 'g';
                } else if (whiteColumn == 7) {
                    realColumn = 'h';
                }

                    realRow = 8;

                System.out.printf("Game over! White pawn is promoted to a queen at %c%d.", realColumn, realRow);
            } else if (blackRow == 7) {
                if (blackColumn == 0) {
                    realColumn = 'a';
                } else if (blackColumn == 1) {
                    realColumn = 'b';
                } else if (blackColumn == 2) {
                    realColumn = 'c';
                } else if (blackColumn == 3) {
                    realColumn = 'd';
                } else if (blackColumn == 4) {
                    realColumn = 'e';
                } else if (blackColumn == 5) {
                    realColumn = 'f';
                } else if (blackColumn == 6) {
                    realColumn = 'g';
                } else if (blackColumn == 7) {
                    realColumn = 'h';
                }

                realRow = 1;
                System.out.printf("Game over! Black pawn is promoted to a queen at %c%d.", realColumn, realRow);
            }
        }

    }
}
