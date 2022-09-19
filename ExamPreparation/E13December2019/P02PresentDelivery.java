package T11ExamPreparation.E13December2019;

import java.util.Scanner;

public class P02PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presents = Integer.parseInt(scanner.nextLine());
        int rowsAndColumns = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowsAndColumns][rowsAndColumns];

        for (int i = 0; i < rowsAndColumns; i++) {
            char[] array = new char[rowsAndColumns];

            String[] arrayS = scanner.nextLine().split(" ");

            for (int j = 0; j < arrayS.length; j++) {
                char currentChar = arrayS[j].charAt(0);
                array[j] = currentChar;
            }

            matrix[i] = array;
        }

        int santaRow = 0;
        int santaColumn = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'S') {
                    santaRow = i;
                    santaColumn = j;
                }
            }
        }

        int niceKids = 0;

        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            switch (command) {
                case "up":
                    matrix[santaRow][santaColumn] = '-';
                    santaRow--;

                    if (matrix[santaRow][santaColumn] == 'V') {
                        matrix[santaRow][santaColumn] = 'S';
                        niceKids++;
                        presents--;

                    } else if (matrix[santaRow][santaColumn] == 'C') {
                        matrix[santaRow][santaColumn] = 'S';

                        if (matrix[santaRow - 1][santaColumn] == 'V' || matrix[santaRow - 1][santaColumn] == 'X') {
                            matrix[santaRow - 1][santaColumn] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow + 1][santaColumn] == 'V' || matrix[santaRow + 1][santaColumn] == 'X') {
                            matrix[santaRow + 1][santaColumn] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow][santaColumn - 1] == 'V' || matrix[santaRow][santaColumn - 1] == 'X') {
                            matrix[santaRow][santaColumn - 1] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow][santaColumn + 1] == 'V' || matrix[santaRow][santaColumn + 1] == 'X') {
                            matrix[santaRow][santaColumn + 1] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        }

                    } else if (matrix[santaRow][santaColumn] == 'X') {
                        matrix[santaRow][santaColumn] = 'S';
                    }
                    break;

                case "down":
                    matrix[santaRow][santaColumn] = '-';
                    santaRow++;

                    if (matrix[santaRow][santaColumn] == 'V') {
                        matrix[santaRow][santaColumn] = 'S';
                        niceKids++;
                        presents--;

                    } else if (matrix[santaRow][santaColumn] == 'C') {
                        matrix[santaRow][santaColumn] = 'S';

                        if (matrix[santaRow - 1][santaColumn] == 'V' || matrix[santaRow - 1][santaColumn] == 'X') {
                            matrix[santaRow - 1][santaColumn] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow + 1][santaColumn] == 'V' || matrix[santaRow + 1][santaColumn] == 'X') {
                            matrix[santaRow + 1][santaColumn] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow][santaColumn - 1] == 'V' || matrix[santaRow][santaColumn - 1] == 'X') {
                            matrix[santaRow][santaColumn - 1] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow][santaColumn + 1] == 'V' || matrix[santaRow][santaColumn + 1] == 'X') {
                            matrix[santaRow][santaColumn + 1] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        }

                    } else if (matrix[santaRow][santaColumn] == 'X') {
                        matrix[santaRow][santaColumn] = 'S';
                    }
                    break;

                case "left":
                    matrix[santaRow][santaColumn] = '-';
                    santaColumn--;

                    if (matrix[santaRow][santaColumn] == 'V') {
                        matrix[santaRow][santaColumn] = 'S';
                        niceKids++;
                        presents--;

                    } else if (matrix[santaRow][santaColumn] == 'C') {
                        matrix[santaRow][santaColumn] = 'S';

                        if (matrix[santaRow - 1][santaColumn] == 'V' || matrix[santaRow - 1][santaColumn] == 'X') {
                            matrix[santaRow - 1][santaColumn] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow + 1][santaColumn] == 'V' || matrix[santaRow + 1][santaColumn] == 'X') {
                            matrix[santaRow + 1][santaColumn] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow][santaColumn - 1] == 'V' || matrix[santaRow][santaColumn - 1] == 'X') {
                            matrix[santaRow][santaColumn - 1] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow][santaColumn + 1] == 'V' || matrix[santaRow][santaColumn + 1] == 'X') {
                            matrix[santaRow][santaColumn + 1] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        }

                    } else if (matrix[santaRow][santaColumn] == 'X') {
                        matrix[santaRow][santaColumn] = 'S';
                    }
                    break;

                case "right":
                    matrix[santaRow][santaColumn] = '-';
                    santaColumn++;

                    if (matrix[santaRow][santaColumn] == 'V') {
                        matrix[santaRow][santaColumn] = 'S';
                        niceKids++;
                        presents--;

                    } else if (matrix[santaRow][santaColumn] == 'C') {
                        matrix[santaRow][santaColumn] = 'S';

                        if (matrix[santaRow - 1][santaColumn] == 'V' || matrix[santaRow - 1][santaColumn] == 'X') {
                            matrix[santaRow - 1][santaColumn] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow + 1][santaColumn] == 'V' || matrix[santaRow + 1][santaColumn] == 'X') {
                            matrix[santaRow + 1][santaColumn] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow][santaColumn - 1] == 'V' || matrix[santaRow][santaColumn - 1] == 'X') {
                            matrix[santaRow][santaColumn - 1] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        } else if (matrix[santaRow][santaColumn + 1] == 'V' || matrix[santaRow][santaColumn + 1] == 'X') {
                            matrix[santaRow][santaColumn + 1] = '-';
                            niceKids++;
                            presents--;

                            if (presents == 0) {
                                break;
                            }

                        }

                    } else if (matrix[santaRow][santaColumn] == 'X') {
                        matrix[santaRow][santaColumn] = 'S';
                    }
                    break;
            }

            if (presents == 0) {
                break;
            }

            command = scanner.nextLine();
        }

        if (presents == 0) {
            System.out.println("Santa ran out of presents!");
        }

        int niceKidsLeft = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                char currentChar = matrix[i][j];

                if (currentChar == 'V') {
                    niceKidsLeft++;
                }

                System.out.print(currentChar + " ");
            }
            System.out.println();
        }

        if (niceKidsLeft == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", niceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKidsLeft);
        }

    }
}

