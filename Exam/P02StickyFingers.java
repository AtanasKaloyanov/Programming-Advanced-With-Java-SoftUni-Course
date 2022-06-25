package Exam;

import java.util.Scanner;

public class P02StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndColumns = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[rowsAndColumns][rowsAndColumns];

        for (int i = 0; i < rowsAndColumns; i++) {
            String[] array = scanner.nextLine().split(" ");

            char[] charArray = new char[rowsAndColumns];

            for (int j = 0; j < array.length; j++) {
                String currentElement = array[j];
                char currentChar = currentElement.charAt(0);
                charArray[j] = currentChar;
            }

            matrix[i] = charArray;
        }

        int playerRow = 0;
        int playerColumn = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                char currentChar = matrix[i][j];
                if (currentChar == 'D') {
                    playerRow = i;
                    playerColumn = j;
                }
            }
        }

        int totalSum = 0;
        boolean policeIsHere = false;


        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];

            switch (currentCommand) {
                case "up":
                    if (playerRow - 1 == -1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[playerRow][playerColumn] = '+';
                        playerRow -= 1;

                        if (matrix[playerRow][playerColumn] == '$') {
                            matrix[playerRow][playerColumn] = 'D';
                            int currentSum = playerRow * playerColumn;
                            totalSum += currentSum;
                            System.out.printf("You successfully stole %d$.%n", currentSum);
                        } else if (matrix[playerRow][playerColumn] == 'P') {
                            matrix[playerRow][playerColumn] = '#';
                            policeIsHere = true;
                            break;
                        } else if (matrix[playerRow][playerColumn] == '+') {
                            matrix[playerRow][playerColumn] = 'D';
                        }
                    }
                    break;

                case "down":
                    if (playerRow + 1 == rowsAndColumns) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[playerRow][playerColumn] = '+';
                        playerRow += 1;

                        if (matrix[playerRow][playerColumn] == '$') {
                            matrix[playerRow][playerColumn] = 'D';
                            int currentSum = playerRow * playerColumn;
                            totalSum += currentSum;
                            System.out.printf("You successfully stole %d$.%n", currentSum);
                        } else if (matrix[playerRow][playerColumn] == 'P') {
                            matrix[playerRow][playerColumn] = '#';
                            policeIsHere = true;
                            break;
                        } else if (matrix[playerRow][playerColumn] == '+') {
                            matrix[playerRow][playerColumn] = 'D';
                        }
                    }
                    break;

                case "left":
                    if (playerColumn - 1 == -1) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[playerRow][playerColumn] = '+';
                        playerColumn -= 1;

                        if (matrix[playerRow][playerColumn] == '$') {
                            matrix[playerRow][playerColumn] = 'D';
                            int currentSum = playerRow * playerColumn;
                            totalSum += currentSum;
                            System.out.printf("You successfully stole %d$.%n", currentSum);
                        } else if (matrix[playerRow][playerColumn] == 'P') {
                            matrix[playerRow][playerColumn] = '#';
                            policeIsHere = true;
                            break;
                        } else if (matrix[playerRow][playerColumn] == '+') {
                            matrix[playerRow][playerColumn] = 'D';
                        }
                    }
                    break;

                case "right":
                    if (playerColumn + 1 == rowsAndColumns) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[playerRow][playerColumn] = '+';
                        playerColumn += 1;

                        if (matrix[playerRow][playerColumn] == '$') {
                            matrix[playerRow][playerColumn] = 'D';
                            int currentSum = playerRow * playerColumn;
                            totalSum += currentSum;
                            System.out.printf("You successfully stole %d$.%n", currentSum);
                        } else if (matrix[playerRow][playerColumn] == 'P') {
                            matrix[playerRow][playerColumn] = '#';
                            policeIsHere = true;
                            break;
                        } else if (matrix[playerRow][playerColumn] == '+') {
                            matrix[playerRow][playerColumn] = 'D';
                        }
                    }
                    break;
            }

            if (policeIsHere) {
                break;
            }
        }

        if (policeIsHere) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", totalSum);
        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalSum);
        }

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
