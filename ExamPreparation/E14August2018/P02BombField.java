package T11ExamPreparation.E14August2018;

import java.util.Scanner;

public class P02BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumn = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[rowsAndColumn][rowsAndColumn];

        for (int i = 0; i < rowsAndColumn; i++) {
            String[] array = scanner.nextLine().split(" ");

            char[] charArray = new char[rowsAndColumn];

            for (int j = 0; j < array.length; j++) {
                String currentElement = array[j];
                char currentChar = currentElement.charAt(0);
                charArray[j] = currentChar;
            }

            matrix[i] = charArray;
        }

        int playerRow = 0;
        int playerColumn = 0;

        for (int i = 0; i < rowsAndColumn; i++) {
            for (int j = 0; j < rowsAndColumn; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 's') {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }

        int bombCounter = 0;
        boolean noBombs = false;
        boolean endOfTheRoud = false;

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            switch (currentCommand) {
                case "left":
                    if (playerColumn - 1 == -1) {
                        playerColumn = 0;
                    } else {
                        playerColumn -= 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = '+';
                            bombCounter++;
                            System.out.println("You found a bomb!");

                            int currentBombCounter = 0;

                            for (int j = 0; j < rowsAndColumn; j++) {
                                for (int k = 0; k < rowsAndColumn; k++) {
                                    char currentChar = matrix[j][k];
                                    if (currentChar == 'B') {
                                        currentBombCounter++;
                                    }
                                }
                            }

                            if (currentBombCounter == 0) {
                                noBombs = true;
                                break;
                            }

                        } else if (matrix[playerRow][playerColumn] == 'e') {
                            endOfTheRoud = true;
                            break;
                        }
                    }
                    break;

                case "right":
                    if (playerColumn + 1 == rowsAndColumn) {
                        playerColumn = rowsAndColumn - 1;
                    } else {
                        playerColumn += 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = '+';
                            bombCounter++;
                            System.out.println("You found a bomb!");

                            int currentBombCounter = 0;

                            for (int j = 0; j < rowsAndColumn; j++) {
                                for (int k = 0; k < rowsAndColumn; k++) {
                                    char currentChar = matrix[j][k];
                                    if (currentChar == 'B') {
                                        currentBombCounter++;
                                    }
                                }
                            }

                            if (currentBombCounter == 0) {
                                noBombs = true;
                                break;
                            }

                        } else if (matrix[playerRow][playerColumn] == 'e') {
                            endOfTheRoud = true;
                            break;
                        }
                    }
                    break;

                case "up":
                    if (playerRow - 1 == -1) {
                        playerRow = 0;
                    } else {
                        playerRow -= 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = '+';
                            bombCounter++;
                            System.out.println("You found a bomb!");

                            int currentBombCounter = 0;

                            for (int j = 0; j < rowsAndColumn; j++) {
                                for (int k = 0; k < rowsAndColumn; k++) {
                                    char currentChar = matrix[j][k];
                                    if (currentChar == 'B') {
                                        currentBombCounter++;
                                    }
                                }
                            }

                            if (currentBombCounter == 0) {
                                noBombs = true;
                                break;
                            }

                        } else if (matrix[playerRow][playerColumn] == 'e') {
                            endOfTheRoud = true;
                            break;
                        }
                    }
                    break;

                case "down":
                    if (playerRow + 1 == rowsAndColumn) {
                        playerRow = rowsAndColumn - 1;
                    } else {
                        playerRow += 1;
                        if (matrix[playerRow][playerColumn] == 'B') {
                            matrix[playerRow][playerColumn] = '+';
                            bombCounter++;
                            System.out.println("You found a bomb!");

                            int currentBombCounter = 0;

                            for (int j = 0; j < rowsAndColumn; j++) {
                                for (int k = 0; k < rowsAndColumn; k++) {
                                    char currentChar = matrix[j][k];
                                    if (currentChar == 'B') {
                                        currentBombCounter++;
                                    }
                                }
                            }

                            if (currentBombCounter == 0) {
                                noBombs = true;
                                break;
                            }

                        } else if (matrix[playerRow][playerColumn] == 'e') {
                            endOfTheRoud = true;
                            break;
                        }
                    }
                    break;
            }

            if (noBombs) {
                break;
            }

            if (endOfTheRoud) {
                break;
            }

        }

        int endBombs = 0;

        for (int i = 0; i < rowsAndColumn; i++) {
            for (int j = 0; j < rowsAndColumn; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'B') {
                    endBombs++;
                }
            }
        }

        if (noBombs) {
            System.out.println("Congratulations! You found all bombs!");
        }

        if (endOfTheRoud) {
            System.out.printf("END! %d bombs left on the field", endBombs);
        }

        if (!noBombs && !endOfTheRoud) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", endBombs, playerRow, playerColumn);
        }

    }
}

