package T11ExamPreparation.E03December2021;

import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];

        for (int i = 0; i < rows; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        int parisRow = 0;
        int parisColumn = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'P') {
                    parisRow = i;
                    parisColumn = j;
                }
            }
        }

        boolean elenaIsHere = false;

        while (power > 0) {
            String[] array = scanner.nextLine().split("\\s+");

            String command = array[0];
            int spartansRow = Integer.parseInt(array[1]);
            int spartansColumn = Integer.parseInt(array[2]);

            matrix[spartansRow][spartansColumn] = 'S';

            power -= 1;

            switch (command) {
                case "up":
                    if (parisRow - 1 != -1) {
                        matrix[parisRow][parisColumn] = '-';
                        parisRow -= 1;
                        if (matrix[parisRow][parisColumn] == 'S') {
                            power -= 2;
                            if (power <= 0) {
                                matrix[parisRow][parisColumn] = 'X';
                            } else {
                                matrix[parisRow][parisColumn] = '-';
                            }
                        }

                        if (matrix[parisRow][parisColumn] == 'H') {
                            elenaIsHere = true;
                            matrix[parisRow][parisColumn] = '-';
                            break;
                        }
                    }
                    break;

                case "down":
                    if (parisRow + 1 < matrix.length) {
                        matrix[parisRow][parisColumn] = '-';
                        parisRow += 1;
                        if (matrix[parisRow][parisColumn] == 'S') {
                            power -= 2;
                            if (power <= 0) {
                                matrix[parisRow][parisColumn] = 'X';
                            } else {
                                matrix[parisRow][parisColumn] = '-';
                            }
                        }

                        if (matrix[parisRow][parisColumn] == 'H') {
                            elenaIsHere = true;
                            matrix[parisRow][parisColumn] = '-';
                            break;
                        }


                    }
                    break;

                case "left":
                    if (parisColumn - 1 >= 0) {
                        matrix[parisRow][parisColumn] = '-';
                        parisColumn -= 1;
                        if (matrix[parisRow][parisColumn] == 'S') {
                            power -= 2;
                            if (power <= 0) {
                                matrix[parisRow][parisColumn] = 'X';
                            } else {
                                matrix[parisRow][parisColumn] = '-';
                            }
                        }

                        if (matrix[parisRow][parisColumn] == 'H') {
                            elenaIsHere = true;
                            matrix[parisRow][parisColumn] = '-';
                            break;
                        }
                    }
                    break;

                case "right":
                    if (parisColumn + 1 < matrix[parisRow].length) {
                        matrix[parisRow][parisColumn] = '-';
                        parisColumn += 1;
                        if (matrix[parisRow][parisColumn] == 'S') {
                            power -= 2;
                            if (power <= 0) {
                                matrix[parisRow][parisColumn] = 'X';
                            } else {
                                matrix[parisRow][parisColumn] = '-';
                            }
                        }

                        if (matrix[parisRow][parisColumn] == 'H') {
                            elenaIsHere = true;
                            matrix[parisRow][parisColumn] = '-';
                            break;
                        }
                    }
                    break;
            }

            if (elenaIsHere) {
                break;
            }

            if (power <= 0) {
                matrix[parisRow][parisColumn] = 'X';
            }
        }

        if (elenaIsHere) {
            System.out.print("Paris has successfully abducted Helen!" + " ");
            System.out.printf("Energy left: %d%n", power);
        } else {
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisColumn);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}

