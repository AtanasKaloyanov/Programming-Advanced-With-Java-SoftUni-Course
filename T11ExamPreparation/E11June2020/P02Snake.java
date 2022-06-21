package T11ExamPreparation.E11June2020;

import java.util.Scanner;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowsAndColumns][rowsAndColumns];

        for (int i = 0; i < rowsAndColumns; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        int snakeRow = 0;
        int snakeColumn = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'S') {
                    snakeRow = i;
                    snakeColumn = j;
                }
            }
        }

        boolean isOut = false;
        int food = 0;
        boolean enoughFood = false;

        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    matrix[snakeRow][snakeColumn] = '.';
                    if (snakeRow - 1 == -1) {
                        isOut = true;
                        break;
                    } else {
                        snakeRow--;
                        if (matrix[snakeRow][snakeColumn] == 'B') {
                            matrix[snakeRow][snakeColumn] = '.';

                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    char currentChar = matrix[i][j];
                                    if (currentChar == 'B') {
                                        snakeRow = i;
                                        snakeColumn = j;
                                    }
                                }
                            }

                            matrix[snakeRow][snakeColumn] = 'S';

                        } else if (matrix[snakeRow][snakeColumn] == '*') {
                            matrix[snakeRow][snakeColumn] = 'S';
                            food++;
                            if (food == 10) {
                                enoughFood = true;
                                break;
                            }
                        } else if (matrix[snakeRow][snakeColumn] == '-') {
                            matrix[snakeRow][snakeColumn] = '.';
                        }
                    }
                    break;

                case "down":
                    matrix[snakeRow][snakeColumn] = '.';
                    if (snakeRow + 1 == rowsAndColumns) {
                        isOut = true;
                        break;
                    } else {
                        snakeRow++;
                        if (matrix[snakeRow][snakeColumn] == 'B') {
                            matrix[snakeRow][snakeColumn] = '.';

                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    char currentChar = matrix[i][j];
                                    if (currentChar == 'B') {
                                        snakeRow = i;
                                        snakeColumn = j;
                                    }
                                }
                            }

                            matrix[snakeRow][snakeColumn] = 'S';

                        } else if (matrix[snakeRow][snakeColumn] == '*') {
                            matrix[snakeRow][snakeColumn] = 'S';
                            food++;
                            if (food == 10) {
                                enoughFood = true;
                                break;
                            }
                        } else if (matrix[snakeRow][snakeColumn] == '-') {
                            matrix[snakeRow][snakeColumn] = '.';
                        }
                    }
                    break;

                case "left":
                    matrix[snakeRow][snakeColumn] = '.';
                    if (snakeColumn - 1 == -1) {
                        isOut = true;
                        break;
                    } else {
                        snakeColumn--;
                        if (matrix[snakeRow][snakeColumn] == 'B') {
                            matrix[snakeRow][snakeColumn] = '.';

                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    char currentChar = matrix[i][j];
                                    if (currentChar == 'B') {
                                        snakeRow = i;
                                        snakeColumn = j;
                                    }
                                }
                            }

                            matrix[snakeRow][snakeColumn] = 'S';

                        } else if (matrix[snakeRow][snakeColumn] == '*') {
                            matrix[snakeRow][snakeColumn] = 'S';
                            food++;
                            if (food == 10) {
                                enoughFood = true;
                                break;
                            }
                        } else if (matrix[snakeRow][snakeColumn] == '-') {
                            matrix[snakeRow][snakeColumn] = '.';
                        }
                    }
                    break;

                case "right":
                    matrix[snakeRow][snakeColumn] = '.';
                    if (snakeColumn + 1 == rowsAndColumns) {
                        isOut = true;
                        break;
                    } else {
                        snakeColumn++;
                        if (matrix[snakeRow][snakeColumn] == 'B') {
                            matrix[snakeRow][snakeColumn] = '.';

                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    char currentChar = matrix[i][j];
                                    if (currentChar == 'B') {
                                        snakeRow = i;
                                        snakeColumn = j;
                                    }
                                }
                            }

                            matrix[snakeRow][snakeColumn] = 'S';

                        } else if (matrix[snakeRow][snakeColumn] == '*') {
                            matrix[snakeRow][snakeColumn] = 'S';
                            food++;
                            if (food == 10) {
                                enoughFood = true;
                                break;
                            }
                        } else if (matrix[snakeRow][snakeColumn] == '-') {
                            matrix[snakeRow][snakeColumn] = '.';
                        }
                    }
                    break;
            }

            if (isOut) {
                break;
            }

            if (enoughFood) {
                break;
            }
        }

       if (isOut) {
           System.out.println("Game over!");
       }

       if (enoughFood) {
           System.out.println("You won! You fed the snake.");
       }

        System.out.printf("Food eaten: %d%n", food);

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
