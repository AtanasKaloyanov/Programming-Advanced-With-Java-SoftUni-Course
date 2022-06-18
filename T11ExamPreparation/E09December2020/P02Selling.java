package T11ExamPreparation.E09December2020;

import java.util.Scanner;

public class P02Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());

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
                if (currentChar == 'S') {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }

        boolean isOut = false;
        boolean rich = false;

        int sum = 0;

        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (playerRow - 1 == -1) {
                        matrix[playerRow][playerColumn] = '-';
                        isOut = true;
                        break;
                    } else {
                        matrix[playerRow][playerColumn] = '-';
                        playerRow -= 1;
                        char currentPosition = matrix[playerRow][playerColumn];

                        if (Character.isDigit(currentPosition)) {
                            sum += Integer.parseInt(currentPosition + "");
                            matrix[playerRow][playerColumn] = 'S';

                            if (sum >= 50) {
                                rich = true;
                                break;
                            }

                        } else if (currentPosition == 'O') {
                            matrix[playerRow][playerColumn] = '-';

                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    char current = matrix[i][j];
                                    if (current == 'O') {
                                        playerRow = i;
                                        playerColumn = j;
                                    }
                                }
                            }

                            matrix[playerRow][playerColumn] = 'S';

                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'S';
                        }
                    }

                    break;

                case "down":
                    if (playerRow + 1 == rowsAndColumns) {
                        matrix[playerRow][playerColumn] = '-';
                        isOut = true;
                        break;
                    } else {
                        matrix[playerRow][playerColumn] = '-';
                        playerRow += 1;
                        char currentPosition = matrix[playerRow][playerColumn];

                        if (Character.isDigit(currentPosition)) {
                            sum += Integer.parseInt(currentPosition + "");
                            matrix[playerRow][playerColumn] = 'S';

                            if (sum >= 50) {
                                rich = true;
                                break;
                            }

                        } else if (currentPosition == 'O') {
                            matrix[playerRow][playerColumn] = '-';

                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    char current = matrix[i][j];
                                    if (current == 'O') {
                                        playerRow = i;
                                        playerColumn = j;
                                    }
                                }
                            }

                            matrix[playerRow][playerColumn] = 'S';

                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'S';
                        }
                    }
                    break;

                case "left":
                    if (playerColumn - 1 == -1) {
                        matrix[playerRow][playerColumn] = '-';
                        isOut = true;
                        break;
                    } else {
                        matrix[playerRow][playerColumn] = '-';
                        playerColumn -= 1;
                        char currentPosition = matrix[playerRow][playerColumn];

                        if (Character.isDigit(currentPosition)) {
                            sum += Integer.parseInt(currentPosition + "");
                            matrix[playerRow][playerColumn] = 'S';

                            if (sum >= 50) {
                                rich = true;
                                break;
                            }

                        } else if (currentPosition == 'O') {
                            matrix[playerRow][playerColumn] = '-';

                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    char current = matrix[i][j];
                                    if (current == 'O') {
                                        playerRow = i;
                                        playerColumn = j;
                                    }
                                }
                            }

                            matrix[playerRow][playerColumn] = 'S';

                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'S';
                        }
                    }
                    break;

                case "right":
                    if (playerColumn + 1 == rowsAndColumns) {
                        matrix[playerRow][playerColumn] = '-';
                        isOut = true;
                        break;
                    } else {
                        matrix[playerRow][playerColumn] = '-';
                        playerColumn += 1;
                        char currentPosition = matrix[playerRow][playerColumn];

                        if (Character.isDigit(currentPosition)) {
                            sum += Integer.parseInt(currentPosition + "");
                            matrix[playerRow][playerColumn] = 'S';

                            if (sum >= 50) {
                                rich = true;
                                break;
                            }

                        } else if (currentPosition == 'O') {
                            matrix[playerRow][playerColumn] = '-';

                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    char current = matrix[i][j];
                                    if (current == 'O') {
                                        playerRow = i;
                                        playerColumn = j;
                                    }
                                }
                            }

                            matrix[playerRow][playerColumn] = 'S';

                        } else if (matrix[playerRow][playerColumn] == '-') {
                            matrix[playerRow][playerColumn] = 'S';
                        }

                    }
                    break;
            }

            if (isOut) {
                break;
            }

            if (rich) {
                break;
            }

        }

        if (isOut) {
            System.out.println("Bad news, you are out of the T11ExamPreparation.E09December2020.bakery.");
        }

        if (rich) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", sum);

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}
