package T11ExamPreparation.E12February2020;

import java.util.Scanner;

public class P02ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());
        int numberCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowsAndColumns][rowsAndColumns];

        for (int i = 0; i < rowsAndColumns; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        int playerRow = 0;
        int playerColumn = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'f') {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }

        boolean win = false;

        for (int i = 0; i < numberCommands; i++) {
            String currentCommand = scanner.nextLine();

            switch (currentCommand) {
                case "up":
                    if (playerRow - 1 == -1) {
                        matrix[playerRow][playerColumn] = '-';
                        playerRow = rowsAndColumns - 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerRow -= 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow = 0;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            win = true;
                            break;
                        }
                    } else {
                        matrix[playerRow][playerColumn] = '-';
                        playerRow -= 1;
                        if (matrix[playerRow][playerColumn] == 'B' && playerRow - 1 >= 0) {
                            playerRow -= 1;
                            matrix[playerRow][playerColumn] = 'f';

                        } else if (matrix[playerRow][playerColumn] == 'B' && playerRow - 1 < 0) {
                            playerRow = rowsAndColumns - 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow += 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            win = true;
                            break;
                        }
                    }
                    break;

                case "down":
                    if (playerRow + 1 == rowsAndColumns) {
                        matrix[playerRow][playerColumn] = '-';
                        playerRow = 0;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerRow = 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow = rowsAndColumns - 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            win = true;
                            break;
                        }
                    } else {
                        matrix[playerRow][playerColumn] = '-';
                        playerRow += 1;
                        if (matrix[playerRow][playerColumn] == 'B' && playerRow + 1 < rowsAndColumns) {
                            playerRow += 1;
                            matrix[playerRow][playerColumn] = 'f';

                        } else if (matrix[playerRow][playerColumn] == 'B' && playerRow + 1 == rowsAndColumns) {
                            playerRow = 0;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow -= 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            win = true;
                            break;
                        }
                    }
                    break;

                case "left":
                    if (playerColumn - 1 == -1) {
                        matrix[playerRow][playerColumn] = '-';
                        playerColumn = rowsAndColumns - 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerColumn -= 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn = 0;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            win = true;
                            break;
                        }
                    } else {
                        matrix[playerRow][playerColumn] = '-';
                        playerColumn -= 1;
                        if (matrix[playerRow][playerColumn] == 'B' && playerColumn - 1 >= 0) {
                            playerColumn -= 1;
                            matrix[playerRow][playerColumn] = 'f';

                        } else if (matrix[playerRow][playerColumn] == 'B' && playerColumn - 1 < 0) {
                            playerColumn = rowsAndColumns - 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn += 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            win = true;
                            break;
                        }
                    }
                    break;

                case "right":
                    if (playerColumn + 1 == rowsAndColumns) {
                        matrix[playerRow][playerColumn] = '-';
                        playerColumn = 0;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerColumn = 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn = rowsAndColumns - 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            win = true;
                            break;
                        }
                    } else {
                        matrix[playerRow][playerColumn] = '-';
                        playerColumn += 1;
                        if (matrix[playerRow][playerColumn] == 'B' && playerColumn + 1 < rowsAndColumns) {
                            playerColumn += 1;
                            matrix[playerRow][playerColumn] = 'f';

                        } else if (matrix[playerRow][playerColumn] == 'B' && playerRow + 1 == rowsAndColumns) {
                            playerColumn = 0;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn -= 1;
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'f';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'f';
                            win = true;
                            break;
                        }
                    }
                    break;
            }

            if (win) {
                break;
            }

        }

        if (win) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
