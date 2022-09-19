package T11ExamPreparation.E05August2021;

import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());
        int commandsNumber = Integer.parseInt(scanner.nextLine());

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
                if (currentChar == 'P') {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }


        boolean isFinished = false;

        for (int i = 0; i < commandsNumber; i++) {
            String currentCommand = scanner.nextLine();
            switch (currentCommand) {
                case "up":
                    if (playerRow - 1 == -1) {
                        matrix[playerRow][playerColumn] = '.';
                        playerRow = rowsAndColumns - 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerRow -= 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow = 0;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == '.') {
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        }
                    } else {
                        matrix[playerRow][playerColumn] = '.';
                        playerRow -= 1;
                        if (matrix[playerRow][playerColumn] == 'B' && playerRow - 1 >= 0) {
                            playerRow -= 1;
                            matrix[playerRow][playerColumn] = 'P';

                        } else if (matrix[playerRow][playerColumn] == 'B' && playerRow - 1 < 0) {
                            playerRow = rowsAndColumns - 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow += 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == '.') {
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        }
                    }
                    break;

                case "down":
                    if (playerRow + 1 == rowsAndColumns) {
                        matrix[playerRow][playerColumn] = '.';
                        playerRow = 0;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerRow = 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow = rowsAndColumns - 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == '.') {
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        }
                    } else {
                        matrix[playerRow][playerColumn] = '.';
                        playerRow += 1;
                        if (matrix[playerRow][playerColumn] == 'B' && playerRow + 1 < rowsAndColumns) {
                            playerRow += 1;
                            matrix[playerRow][playerColumn] = 'P';

                        } else if (matrix[playerRow][playerColumn] == 'B' && playerRow + 1 == rowsAndColumns) {
                            playerRow = 0;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerRow -= 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == '.') {
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        }
                    }
                    break;

                case "left":
                    if (playerColumn - 1 == -1) {
                        matrix[playerRow][playerColumn] = '.';
                        playerColumn = rowsAndColumns - 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerColumn -= 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn = 0;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == '.') {
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        }
                    } else {
                        matrix[playerRow][playerColumn] = '.';
                        playerColumn -= 1;
                        if (matrix[playerRow][playerColumn] == 'B' && playerColumn - 1 >= 0) {
                            playerColumn -= 1;
                            matrix[playerRow][playerColumn] = 'P';

                        } else if (matrix[playerRow][playerColumn] == 'B' && playerColumn - 1 < 0) {
                            playerColumn = rowsAndColumns - 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn += 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == '.') {
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        }
                    }
                    break;

                case "right":
                    if (playerColumn + 1 == rowsAndColumns) {
                        matrix[playerRow][playerColumn] = '.';
                        playerColumn = 0;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            playerColumn = 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn = rowsAndColumns - 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == '.') {
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        }
                    } else {
                        matrix[playerRow][playerColumn] = '.';
                        playerColumn += 1;
                        if (matrix[playerRow][playerColumn] == 'B' && playerColumn + 1 < rowsAndColumns) {
                            playerColumn += 1;
                            matrix[playerRow][playerColumn] = 'P';

                        } else if (matrix[playerRow][playerColumn] == 'B' && playerRow + 1 == rowsAndColumns) {
                            playerColumn = 0;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'T') {
                            playerColumn -= 1;
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == '.') {
                            matrix[playerRow][playerColumn] = 'P';
                        } else if (matrix[playerRow][playerColumn] == 'F') {
                            matrix[playerRow][playerColumn] = 'P';
                            isFinished = true;
                            break;
                        }
                    }
                    break;
            }

            if (isFinished) {
                break;
            }

        }

        if (isFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
