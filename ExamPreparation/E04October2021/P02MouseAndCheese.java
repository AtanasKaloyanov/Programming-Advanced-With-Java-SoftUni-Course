package T11ExamPreparation.E04October2021;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowsAndColumns][rowsAndColumns];

        for (int i = 0; i < rowsAndColumns; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        int mouseRow = 0;
        int mouseColumn = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'M') {
                    mouseRow = i;
                    mouseColumn = j;
                }
            }
        }

        boolean out = false;
        int cheeseCounter = 0;

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    matrix[mouseRow][mouseColumn] = '-';

                    if (mouseRow - 1 == -1) {
                        out = true;
                        break;
                    } else {
                        mouseRow--;
                        if (matrix[mouseRow][mouseColumn] == 'c') {
                            matrix[mouseRow][mouseColumn] = 'M';
                            cheeseCounter++;
                        } else if (matrix[mouseRow][mouseColumn] == 'B') {
                            matrix[mouseRow][mouseColumn] = '-';
                            mouseRow--;

                            if (matrix[mouseRow][mouseColumn] == 'c') {
                                cheeseCounter++;
                            }

                            matrix[mouseRow][mouseColumn] = 'M';
                        } else if (matrix[mouseRow][mouseColumn] == '-') {
                            matrix[mouseRow][mouseColumn] = 'M';
                        }
                    }
                    break;

                case "down":
                    matrix[mouseRow][mouseColumn] = '-';

                    if (mouseRow + 1 == rowsAndColumns) {
                        out = true;
                        break;
                    } else {
                        mouseRow++;
                        if (matrix[mouseRow][mouseColumn] == 'c') {
                            matrix[mouseRow][mouseColumn] = 'M';
                            cheeseCounter++;
                        } else if (matrix[mouseRow][mouseColumn] == 'B') {
                            matrix[mouseRow][mouseColumn] = '-';
                            mouseRow++;

                            if (matrix[mouseRow][mouseColumn] == 'c') {
                                cheeseCounter++;
                            }

                            matrix[mouseRow][mouseColumn] = 'M';
                        } else if (matrix[mouseRow][mouseColumn] == '-') {
                            matrix[mouseRow][mouseColumn] = 'M';
                        }
                    }
                    break;

                case "left":
                    matrix[mouseRow][mouseColumn] = '-';

                    if (mouseColumn - 1 == -1) {
                        out = true;
                        break;
                    } else {
                        mouseColumn--;
                        if (matrix[mouseRow][mouseColumn] == 'c') {
                            matrix[mouseRow][mouseColumn] = 'M';
                            cheeseCounter++;
                        } else if (matrix[mouseRow][mouseColumn] == 'B') {
                            matrix[mouseRow][mouseColumn] = '-';
                            mouseColumn--;

                            if (matrix[mouseRow][mouseColumn] == 'c') {
                                cheeseCounter++;
                            }

                            matrix[mouseRow][mouseColumn] = 'M';
                        } else if (matrix[mouseRow][mouseColumn] == '-') {
                            matrix[mouseRow][mouseColumn] = 'M';
                        }
                    }
                    break;

                case "right":
                    matrix[mouseRow][mouseColumn] = '-';

                    if (mouseColumn + 1 == rowsAndColumns) {
                        out = true;
                        break;
                    } else {
                        mouseColumn++;
                        if (matrix[mouseRow][mouseColumn] == 'c') {
                            matrix[mouseRow][mouseColumn] = 'M';
                            cheeseCounter++;
                        } else if (matrix[mouseRow][mouseColumn] == 'B') {
                            matrix[mouseRow][mouseColumn] = '-';
                            mouseColumn++;

                            if (matrix[mouseRow][mouseColumn] == 'c') {
                                cheeseCounter++;
                            }

                            matrix[mouseRow][mouseColumn] = 'M';
                        } else if (matrix[mouseRow][mouseColumn] == '-') {
                            matrix[mouseRow][mouseColumn] = 'M';
                        }
                    }
                    break;
            }

            if (out) {
                break;
            }

            command = scanner.nextLine();
        }

        if (out) {
            System.out.println("Where is the mouse?");
        }

        if (cheeseCounter >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseCounter);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseCounter);
        }

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

