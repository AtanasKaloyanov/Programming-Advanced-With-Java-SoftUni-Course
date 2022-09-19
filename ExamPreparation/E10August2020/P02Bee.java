package T11ExamPreparation.E10August2020;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rowsAndColumns][rowsAndColumns];

        for (int i = 0; i < rowsAndColumns; i++) {
            char[] array = scanner.nextLine().toCharArray();
            matrix[i] = array;
        }

        int beeRow = 0;
        int beeColumn = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                char currentPosition = matrix[i][j];
                if (currentPosition == 'B') {
                    beeRow = i;
                    beeColumn = j;
                }
            }
        }

        boolean isOut = false;
        int flowerCount = 0;

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    matrix[beeRow][beeColumn] = '.';
                    if (beeRow - 1 == -1) {
                        isOut = true;
                        break;
                    } else {
                        beeRow--;
                        if (matrix[beeRow][beeColumn] == 'f') {
                            matrix[beeRow][beeColumn] = 'B';
                            flowerCount++;
                        } else if (matrix[beeRow][beeColumn] == 'O') {
                            matrix[beeRow][beeColumn] = '.';
                            if (beeRow - 1 == -1) {
                                isOut = true;
                                break;
                            } else {
                                beeRow--;
                                if (matrix[beeRow][beeColumn] == 'f') {
                                    flowerCount++;
                                }
                                matrix[beeRow][beeColumn] = 'B';
                            }

                        } else if (matrix[beeRow][beeColumn] == '.') {
                            matrix[beeRow][beeColumn] = 'B';
                        }
                    }
                    break;

                case "down":
                    matrix[beeRow][beeColumn] = '.';
                    if (beeRow + 1 == rowsAndColumns) {
                        isOut = true;
                        break;
                    } else {
                        beeRow++;
                        if (matrix[beeRow][beeColumn] == 'f') {
                            matrix[beeRow][beeColumn] = 'B';
                            flowerCount++;
                        } else if (matrix[beeRow][beeColumn] == 'O') {
                            matrix[beeRow][beeColumn] = '.';
                            if (beeRow + 1 == rowsAndColumns) {
                                isOut = true;
                                break;
                            } else {
                                beeRow++;
                                if (matrix[beeRow][beeColumn] == 'f') {
                                    flowerCount++;
                                }
                                matrix[beeRow][beeColumn] = 'B';
                            }

                        } else if (matrix[beeRow][beeColumn] == '.') {
                            matrix[beeRow][beeColumn] = 'B';
                        }
                    }
                    break;

                case "left":
                    matrix[beeRow][beeColumn] = '.';
                    if (beeColumn - 1 == -1) {
                        isOut = true;
                        break;
                    } else {
                        beeColumn--;
                        if (matrix[beeRow][beeColumn] == 'f') {
                            matrix[beeRow][beeColumn] = 'B';
                            flowerCount++;
                        } else if (matrix[beeRow][beeColumn] == 'O') {
                            matrix[beeRow][beeColumn] = '.';
                            if (beeColumn - 1 == -1) {
                                isOut = true;
                                break;
                            } else {
                                beeColumn--;
                                if (matrix[beeRow][beeColumn] == 'f') {
                                    flowerCount++;
                                }
                                matrix[beeRow][beeColumn] = 'B';
                            }

                        } else if (matrix[beeRow][beeColumn] == '.') {
                            matrix[beeRow][beeColumn] = 'B';
                        }
                    }
                    break;

                case "right":
                    matrix[beeRow][beeColumn] = '.';
                    if (beeColumn + 1 == rowsAndColumns) {
                        isOut = true;
                        break;
                    } else {
                        beeColumn++;
                        if (matrix[beeRow][beeColumn] == 'f') {
                            matrix[beeRow][beeColumn] = 'B';
                            flowerCount++;
                        } else if (matrix[beeRow][beeColumn] == 'O') {
                            matrix[beeRow][beeColumn] = '.';
                            if (beeColumn + 1 == rowsAndColumns) {
                                isOut = true;
                                break;
                            } else {
                                beeColumn++;
                                if (matrix[beeRow][beeColumn] == 'f') {
                                    flowerCount++;
                                }
                                matrix[beeRow][beeColumn] = 'B';
                            }

                        } else if (matrix[beeRow][beeColumn] == '.') {
                            matrix[beeRow][beeColumn] = 'B';
                        }
                    }
                    break;

            }
            if (isOut) {
                break;
            }

            command = scanner.nextLine();
        }

        if (isOut) {
            System.out.println("The bee got lost!");
        }

            if (flowerCount < 5) {
                System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowerCount);
            } else {
                System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowerCount);
            }

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
