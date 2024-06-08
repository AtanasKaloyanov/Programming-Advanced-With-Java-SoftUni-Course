package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double haiganHealth = 3_000_000;
        int playerHealth = 18_500;

        int playerRow = 7;
        int playerColumn = 7;

        String lastSpell = "";
        boolean activeCloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (playerHealth > 0 && haiganHealth > 0) {
            haiganHealth -= damage;

            if (activeCloud) {
                playerHealth -= 3500;
                activeCloud = false;
            }

            if (playerHealth <= 0 || haiganHealth <= 0) {
                break;
            }

            String[] array = scanner.nextLine().split("\\s+");

            String spell = array[0];
            int magigRow = Integer.parseInt(array[1]);
            int magicColumn = Integer.parseInt(array[2]);

            boolean[][] matrix = new boolean[15][15];
            for (int i = magigRow - 1; i <= magigRow + 1; i++) {
                if (i >= 0 && i < 15) {
                    for (int j = magicColumn - 1; j <= magicColumn + 1; j++) {
                        if (j >= 0 && j < 15) {
                            matrix[i][j] = true;
                        }
                    }
                }
            }

            if (matrix[playerRow][playerColumn]) {
                if (isRowValid(matrix, playerRow - 1) && !matrix[playerRow - 1][playerColumn]) {
                    playerRow--; // move up
                } else if (isColumnValid(matrix, playerColumn + 1) && !matrix[playerRow][playerColumn + 1]) {
                    playerColumn++; // move right
                } else if (isRowValid(matrix, playerRow + 1) && !matrix[playerRow + 1][playerColumn]) {
                    playerRow++; // move down
                } else if (isColumnValid(matrix, playerColumn - 1) && !matrix[playerRow][playerColumn - 1]) {
                    playerColumn--; // move left
                }

                if (matrix[playerRow][playerColumn]) {
                    switch (spell) {
                        case "Cloud":
                            playerHealth -= 3500;
                            activeCloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHealth -= 6000;
                            lastSpell = "Eruption";
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }

        if (haiganHealth > 0) {
            System.out.printf("Heigan: %.2f%n", haiganHealth);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHealth > 0) {
            System.out.printf("Player: %d%n", playerHealth);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + playerRow + ", " + playerColumn);
    }

    private static boolean isRowValid(boolean[][] matrix, int playerRow) {
        return playerRow >= 0 && playerRow < 15;
    }

    private static boolean isColumnValid(boolean[][] matrix, int playerColumn) {
        return playerColumn >= 0 && playerColumn < 15;
    }

}