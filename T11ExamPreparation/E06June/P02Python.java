package T11ExamPreparation.E06June;
import java.util.Scanner;

public class P02Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pythonLength = 1;
        int rowsAndColumns = Integer.parseInt(scanner.nextLine());
        String[] array = scanner.nextLine().split(", ");

        char[][] matrix = new char[rowsAndColumns][rowsAndColumns];
        int pythonRow = 0;
        int pythonColumn = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            char[] matrixRow = new char[rowsAndColumns];
            String[] stringArray = scanner.nextLine().split("\\s+");
            for (int j = 0; j < stringArray.length; j++) {
                String currentString = stringArray[j];
                char charToAdd = currentString.charAt(0);
                matrixRow[j] = charToAdd;
            }
            matrix[i] = matrixRow;
        }


        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                if (matrix[i][j] == 's') {
                    pythonRow = i;
                    pythonColumn = j;
                }
            }
        }

        boolean isDead = false;
        boolean noFood = false;

        for (int i = 0; i < array.length; i++) {
            String currentCommand = array[i];
            switch (currentCommand) {
                case "left":
                    if (pythonColumn - 1 == -1) {
                        pythonColumn = rowsAndColumns - 1;
                    } else {
                        pythonColumn -= 1;
                    }

                    if (matrix[pythonRow][pythonColumn] == '*') {
                        matrix[pythonRow][pythonColumn] = 's';
                    } else if (matrix[pythonRow][pythonColumn] == 'e') {
                        isDead = true;
                        break;
                    } else if (matrix[pythonRow][pythonColumn] == 'f') {
                        matrix[pythonRow][pythonColumn] = 's';
                        pythonLength++;
                    }
                    break;

                case "right":
                    if (pythonColumn + 1 == rowsAndColumns) {
                        pythonColumn = 0;
                    } else {
                        pythonColumn += 1;
                    }

                    if (matrix[pythonRow][pythonColumn] == '*') {
                        matrix[pythonRow][pythonColumn] = 's';
                    } else if (matrix[pythonRow][pythonColumn] == 'e') {
                        isDead = true;
                        break;
                    } else if (matrix[pythonRow][pythonColumn] == 'f') {
                        matrix[pythonRow][pythonColumn] = 's';
                        pythonLength++;
                    }

                    break;

                case "up":
                    if (pythonRow - 1 == -1) {
                        pythonRow = rowsAndColumns - 1;
                    } else {
                        pythonRow -= 1;
                    }

                    if (matrix[pythonRow][pythonColumn] == '*') {
                        matrix[pythonRow][pythonColumn] = 's';
                    } else if (matrix[pythonRow][pythonColumn] == 'e') {
                        isDead = true;
                        break;
                    } else if (matrix[pythonRow][pythonColumn] == 'f') {
                        matrix[pythonRow][pythonColumn] = 's';
                        pythonLength++;
                    }

                    break;

                case "down":
                    if (pythonRow + 1 == rowsAndColumns) {
                        pythonRow = 0;
                    } else {
                        pythonRow += 1;
                    }

                    if (matrix[pythonRow][pythonColumn] == '*') {
                        matrix[pythonRow][pythonColumn] = 's';
                    } else if (matrix[pythonRow][pythonColumn] == 'e') {
                        isDead = true;
                        break;
                    } else if (matrix[pythonRow][pythonColumn] == 'f') {
                        matrix[pythonRow][pythonColumn] = 's';
                        pythonLength++;
                    }
                    break;
            }

            if (isDead) {
                break;
            } else {
                int lastFood = 0;

                for (int a = 0; a < rowsAndColumns; a++) {
                    for (int j = 0; j < rowsAndColumns; j++) {
                        char currentChar = matrix[a][j];
                        if (currentChar == 'f') {
                            lastFood++;
                        }
                    }
                }

                if (lastFood == 0) {
                    noFood = true;
                    break;
                }
            }

        }

        int lastFood = 0;

        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                if (matrix[i][j] == 'f') {
                    lastFood++;
                }
            }
        }

        if (isDead) {
            System.out.println("You lose! Killed by an enemy!");
        } else {
            if (noFood) {
                System.out.printf("You win! Final python length is %d", pythonLength);
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.", lastFood);
            }
        }

    }
}
