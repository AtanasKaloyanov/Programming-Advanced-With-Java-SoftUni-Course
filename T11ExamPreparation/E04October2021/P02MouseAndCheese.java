package T11ExamPreparation.E04October2021;

import java.util.Scanner;

public class P02MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        int mouseRow = 0;
        int mouseColumn = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'M') {
                    mouseRow = i;
                    mouseColumn = j;
                }
            }
        }

        String command = scanner.nextLine();
        boolean out = false;
        int cheeseCounter = 0;

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    if (mouseRow - 1 < 0) {
                        matrix[mouseRow][mouseColumn] = '-';
                        out = true;
                        break;
                    } else {
                        matrix[mouseRow][mouseColumn] = '-';
                        mouseRow -= 1;
                        if (matrix[mouseRow][mouseColumn] == 'c') {
                            matrix[mouseRow][mouseColumn] = 'M';
                            cheeseCounter++;
                        } else if (matrix[mouseRow][mouseColumn] == 'B') {
                            matrix[mouseRow][mouseColumn] = '-';
                            mouseRow -= 1;
                            if (matrix[mouseRow][mouseColumn] == 'c') {
                                cheeseCounter++;
                                matrix[mouseRow][mouseColumn] = 'M';
                            } else {
                                matrix[mouseRow][mouseColumn] = 'M';
                            }
                        } else if (matrix[mouseRow][mouseColumn] == '-') {
                            matrix[mouseRow][mouseColumn] = 'M';
                        }

                    }
                    break;

                case "down":
                    if (mouseRow + 1 >= matrix.length) {
                        out = true;
                        matrix[mouseRow][mouseColumn] = '-';
                        break;
                    } else {
                        matrix[mouseRow][mouseColumn] = '-';
                        mouseRow += 1;

                        if (matrix[mouseRow][mouseColumn] == 'c') {
                            matrix[mouseRow][mouseColumn] = 'M';
                            cheeseCounter++;
                        } else if (matrix[mouseRow][mouseColumn] == 'B') {
                            matrix[mouseRow][mouseColumn] = '-';
                            mouseRow += 1;
                            if (matrix[mouseRow][mouseColumn] == 'c') {
                                cheeseCounter++;
                                matrix[mouseRow][mouseColumn] = 'M';
                            } else {
                                matrix[mouseRow][mouseColumn] = 'M';
                            }
                        } else if (matrix[mouseRow][mouseColumn] == '-') {
                            matrix[mouseRow][mouseColumn] = 'M';
                        }

                    }
                    break;

                case "left":
                    if (mouseColumn - 1 < 0) {
                        out = true;
                        matrix[mouseRow][mouseColumn] = '-';
                        break;
                    } else {
                        matrix[mouseRow][mouseColumn] = '-';
                        mouseColumn -= 1;
                        if (matrix[mouseRow][mouseColumn] == 'c') {
                            matrix[mouseRow][mouseColumn] = 'M';
                            cheeseCounter++;
                        } else if (matrix[mouseRow][mouseColumn] == 'B') {
                            matrix[mouseRow][mouseColumn] = '-';
                            mouseColumn -= 1;
                            if (matrix[mouseRow][mouseColumn] == 'c') {
                                cheeseCounter++;
                                matrix[mouseRow][mouseColumn] = 'M';
                            } else {
                                matrix[mouseRow][mouseColumn] = 'M';
                            }
                        } else if (matrix[mouseRow][mouseColumn] == '-') {
                            matrix[mouseRow][mouseColumn] = 'M';
                        }

                    }
                    break;

                case "right":
                    if (mouseColumn + 1 >= matrix[mouseRow].length) {
                        out = true;
                        matrix[mouseRow][mouseColumn] = '-';
                        break;
                    } else {
                        matrix[mouseRow][mouseColumn] = '-';
                        mouseColumn += 1;
                        if (matrix[mouseRow][mouseColumn] == 'c') {
                            matrix[mouseRow][mouseColumn] = 'M';
                            cheeseCounter++;
                        } else if (matrix[mouseRow][mouseColumn] == 'B') {
                            matrix[mouseRow][mouseColumn] = '-';
                            mouseColumn += 1;
                            if (matrix[mouseRow][mouseColumn] == 'c') {
                                cheeseCounter++;
                                matrix[mouseRow][mouseColumn] = 'M';
                            } else {
                                matrix[mouseRow][mouseColumn] = 'M';
                            }
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

        if (cheeseCounter < 5) {
            int neededCheese = 5 - cheeseCounter;
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", neededCheese);
        } else {
            System.out.printf("Great job the mouse is fed %d cheeses%n", cheeseCounter);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
