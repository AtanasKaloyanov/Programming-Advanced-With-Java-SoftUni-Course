package T11ExamPreparation.E01April2022.P03Basket;

import java.util.Scanner;

public class P02Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsAndColumns = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowsAndColumns][rowsAndColumns];

        for (int i = 0; i < rowsAndColumns; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        int rowOfTheArmy = 0;
        int colOfTheArmy = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                if (matrix[i][j] == 'A') {
                    rowOfTheArmy = i;
                    colOfTheArmy = j;
                }
            }
        }


        int sum = 0;
        while (sum < 65) {
            boolean outOfMatrix = false;
            String command = scanner.nextLine();
            switch (command) {

                case "up":
                    matrix[rowOfTheArmy][colOfTheArmy] = '-';
                    rowOfTheArmy -= 1;
                    if (rowOfTheArmy == -1) {
                        outOfMatrix = true;
                        break;
                    } else {
                        char currentPosition = matrix[rowOfTheArmy][colOfTheArmy];
                        if (Character.isDigit(currentPosition)) {
                            sum += Integer.parseInt(String.valueOf(currentPosition));
                            matrix[rowOfTheArmy][colOfTheArmy] = 'A';
                        } else if (currentPosition == 'M') {
                            matrix[rowOfTheArmy][colOfTheArmy] = '-';
                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    if (matrix[i][j] == 'M') {
                                        matrix[i][j] = 'A';
                                        rowOfTheArmy = i;
                                        colOfTheArmy = j;
                                    }
                                }
                            }

                        }
                    }

                    break;

                case "down":
                    matrix[rowOfTheArmy][colOfTheArmy] = '-';
                    rowOfTheArmy += 1;
                    if (rowOfTheArmy >= matrix.length) {
                        outOfMatrix = true;
                        break;
                    } else {
                        char currentPosition = matrix[rowOfTheArmy][colOfTheArmy];
                        if (Character.isDigit(currentPosition)) {
                            sum += Integer.parseInt(String.valueOf(currentPosition));
                            matrix[rowOfTheArmy][colOfTheArmy] = 'A';
                        } else if (currentPosition == 'M') {
                            matrix[rowOfTheArmy][colOfTheArmy] = '-';
                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    if (matrix[i][j] == 'M') {
                                        matrix[i][j] = 'A';
                                        rowOfTheArmy = i;
                                        colOfTheArmy = j;
                                    }
                                }
                            }

                        }
                    }
                    break;

                case "left":
                    matrix[rowOfTheArmy][colOfTheArmy] = '-';
                    colOfTheArmy -= 1;
                    if (colOfTheArmy == -1) {
                        outOfMatrix = true;
                        break;
                    } else {
                        char currentPosition = matrix[rowOfTheArmy][colOfTheArmy];
                        if (Character.isDigit(currentPosition)) {
                            sum += Integer.parseInt(String.valueOf(currentPosition));
                            matrix[rowOfTheArmy][colOfTheArmy] = 'A';
                        } else if (currentPosition == 'M') {
                            matrix[rowOfTheArmy][colOfTheArmy] = '-';
                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    if (matrix[i][j] == 'M') {
                                        matrix[i][j] = 'A';
                                        rowOfTheArmy = i;
                                        colOfTheArmy = j;
                                    }
                                }
                            }

                        }
                    }
                    break;

                case "right":
                    matrix[rowOfTheArmy][colOfTheArmy] = '-';
                    colOfTheArmy += 1;
                    if (colOfTheArmy >= matrix.length) {
                        outOfMatrix = true;
                        break;
                    } else {
                        char currentPosition = matrix[rowOfTheArmy][colOfTheArmy];
                        if (Character.isDigit(currentPosition)) {
                            sum += Integer.parseInt(String.valueOf(currentPosition));
                            matrix[rowOfTheArmy][colOfTheArmy] = 'A';
                        } else if (currentPosition == 'M') {
                            matrix[rowOfTheArmy][colOfTheArmy] = '-';
                            for (int i = 0; i < rowsAndColumns; i++) {
                                for (int j = 0; j < rowsAndColumns; j++) {
                                    if (matrix[i][j] == 'M') {
                                        matrix[i][j] = 'A';
                                        rowOfTheArmy = i;
                                        colOfTheArmy = j;
                                    }
                                }
                            }

                        }
                    }
                    break;
            }
            if (outOfMatrix) {
                break;
            }

        }

        if (sum < 65) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", sum);

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
