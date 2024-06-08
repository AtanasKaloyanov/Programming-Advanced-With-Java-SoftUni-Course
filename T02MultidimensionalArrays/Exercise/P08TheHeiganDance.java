package T02MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    // 1. Static variables initialization
    private static int heroLife = 18500;
    private static double heiganLife = 3000000;
    private static int heroRow = 7;
    private static int heroColumn = 7;
    private static String currentMagic = "";
    private static boolean hasPlague = false;

    public static void main(String[] args) {
        // 2. Input reading
        Scanner scanner = new Scanner(System.in);
        double heroDamage = Double.parseDouble(scanner.nextLine());

        // 3. Cycle starting. The condition is alive hero
        while (heroLife > 0) {
            // 3.1. The hero attacks
            heiganLife -= heroDamage;

            // 3.2. If there is a plague from the previous turn the hero takes damage
            if (hasPlague) {
                heroLife -= 3500;
                hasPlague = false;
            }

            // 3.3. If the hero or Heigan is dead the cycle ends
            if (heroLife <= 0 || heiganLife <= 0) {
                break;
            }

            // 3.4. Magic input reading
            String[] currentArray = scanner.nextLine().split(" ");
            currentMagic = currentArray[0];
            int magicRow = Integer.parseInt(currentArray[1]);
            int magicColumn = Integer.parseInt(currentArray[2]);

            // 3.5. If the hero is on the spelled position moves or takes damage
            if (isSpelled(heroRow, heroColumn, magicRow, magicColumn)) {
                if (!isSpelled(heroRow - 1, heroColumn, magicRow, magicColumn) && (!isWall(heroRow - 1, heroColumn))) {
                    heroRow--;
                } else if (!isSpelled(heroRow, heroColumn + 1, magicRow, magicColumn) && (!isWall(heroRow, heroColumn + 1))) {
                    heroColumn++;
                } else if (!isSpelled(heroRow + 1, heroColumn, magicRow, magicColumn) && (!isWall(heroRow + 1, heroColumn))) {
                    heroRow++;
                } else if (!isSpelled(heroRow, heroColumn - 1, magicRow, magicColumn) && (!isWall(heroRow, heroColumn - 1))) {
                    heroColumn--;
                } else {
                    heroLife = magicAttacked(heroLife, currentMagic);
                }
            }

        }

        // 4. Output printing - 3 rows and for the first two rows there are 2 cases
        if (heiganLife <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heiganLife);
        }

        if (heroLife <= 0) {
            String magicMessage = currentMagic.equals("Cloud") ? "Plague Cloud" : "Eruption";
            System.out.printf("Player: Killed by %s\n", magicMessage);
        } else {
            System.out.printf("Player: %d\n", heroLife);
        }

        System.out.printf("Final position: %d, %d", heroRow, heroColumn);
    }

    private static boolean isWall(int heroRow, int heroColumn) {
        return heroRow == -1 || heroRow == 15 || heroColumn == -1 || heroColumn == 15;
    }

    private static boolean isSpelled(int heroRow, int heroColumn, int magicRow, int magicColumn) {
        return (heroRow >= magicRow - 1) && (heroRow <= magicRow + 1)
                && (heroColumn >= magicColumn - 1) && (heroColumn <= magicColumn + 1);
    }

    private static int magicAttacked(int heroLife, String currentMagic) {
        switch (currentMagic) {
            case "Eruption":
                heroLife -= 6000;
                break;

            case "Cloud":
                heroLife -= 3500;
                hasPlague = true;
                break;
        }
        return heroLife;
    }

}

/*
 Input 1:

Heigan's life - 3,000,000
Hero's life - 18,500
Hero's damage - 10 000

1. Cloud 7 7

Heigan's life - 3,000,000 - 10 000 = 2 990 000
Hero's life - 18 500 - 3 500 = 15 000

Hero's position - 7 7

2. Eruption 6 7

Heigan's life   2 990 000 - 10 000 = 2 980 000
Hero's life -   15 000 - 3500  = 11 500

hero's position 8 7

3. Eruption 8 7

Heigan's life   2 980 000 - 10 000 = 2 970 000
Hero's life -  11 500 - 6 000 = 5 500

hero's position 8 7

4. Eruption 8 7

Heigan's life   2 970 000 - 10 000 = 2 960 000
Hero's life -   5 500 - 6000 = - 500

=> The hero is dead

Input 2:

Heigan's life - 3,000,000
Hero's life - 18,500
Hero's damage - 500 000

Hero's position - 7 7

1.   Cloud 7 6

Heigan's life - 3,000,000 - 500 000 = 2 500 000
Hero's life - 18,500

Hero's position - 7 8

2. Eruption 7 8

Heigan's life - 2,500,000 - 500 000 = 2 000 000
Hero's life - 18,500 - 6 000 = 12 500

Hero's position - 7 8

3. Eruption 7 7

Heigan's life - 2,000,000 - 500 000 = 1 500 000
Hero's life - 12 500

hero's position - 7 9

4. Cloud 7 8

Heigan's life - 1 500 000 - 500 000 = 1 000 000
Hero's life - 12 500

hero's position - 7 10

5. Eruption 7 9

Heigan's life - 1 000 000 - 500 000 = 500 000
Hero's life - 12 500

heroe's position - 7 11

6. Eruption 6 14

Heigan's life - 500 000 - 500 000 = 0
Hero's life - 12 500

hero's position - 7 11

7. Eruption 7 11

Heigan's dead

Input 3:

Heigan's life - 3,000,000
Hero's life - 18,500
Hero's damage - 12500.66

1. Cloud 7 7

Heigan's life - 3,000,000 - 12 500.66 = 2 987 499,34
Hero's life - 18,500 - 3 500 = 15 000

hero's position - 7 7

2. Cloud 7 7

Heigan's life - 2 987 499,34 - 12 500.66 = 2 974 998,68
Hero's life - 15 000 - 2 * 3 500 = 8 000

hero's position - 7 7

3. Cloud 7 7

Heigan's life - 2 974 998,68 - 12 500.66 = 2 962 498,02
Hero's life - 8 000 - 2 * 3 500 = 1 000

hero's position - 7 7

4. Cloud 7 7

Heigan's life - 2 962 498,02 - 12 500.66 = 2 949 997.36
Hero's life - 1 000 - 2 * 3 500 = - 6 000

hero's position - 7 7
 */

