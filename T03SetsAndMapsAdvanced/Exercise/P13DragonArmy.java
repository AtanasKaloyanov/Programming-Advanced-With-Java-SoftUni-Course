package T03SetsAndMapsAdvanced.Exercise;

import com.sun.source.doctree.EscapeTree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;

public class P13DragonArmy {
    static class Dragon {
        private int damage;
        private int health;
        private int armor;

        public Dragon(int damage, int health, int armor) {
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public int getDamage() {
            return damage;
        }

        public int getHealth() {
            return health;
        }

        public int getArmor() {
            return armor;
        }
    }

    public static void main(String[] args) {
        // 1. Input reading and adding it into a map

        //   type        name   dragon
        Map<String, Map<String, Dragon>> dragonByNameMapByType = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String type = array[0];
            String name = array[1];

            int damage = 45;
            String damageInfo = array[2];
            if (!damageInfo.equals("null")) {
                damage = Integer.parseInt(damageInfo);
            }

            int health = 250;
            String healthInfo = array[3];
            if (!healthInfo.equals("null")) {
                health = Integer.parseInt(healthInfo);
            }

            int armor = 10;
            String armorInfo = array[4];
            if (!armorInfo.equals("null")) {
                armor = Integer.parseInt(armorInfo);
            }

            dragonByNameMapByType.putIfAbsent(type, new TreeMap<>());
            Map<String, Dragon> dragonsByName = dragonByNameMapByType.get(type);
            Dragon dragon = new Dragon(damage, health, armor);
            dragonsByName.put(name, dragon);
            dragonByNameMapByType.put(type, dragonsByName);
        }

        // 3. Printing:
        dragonByNameMapByType.forEach((type, dragonByName) -> {
            double damageAvg = getDamageAvg(dragonByName);
            double healthAvg = getHealthAvg(dragonByName);
            double armorAvg = getArmorAvg(dragonByName);
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", type, damageAvg, healthAvg, armorAvg);
            dragonByName.forEach((name, dragon) -> {
                int damage = dragon.getDamage();
                int health = dragon.getHealth();
                int armor = dragon.getArmor();
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", name, damage, health, armor);
            });
        });

    }

    private static double getDamageAvg(Map<String, Dragon> dragonByName) {
        return dragonByName.values()
                .stream()
                .mapToInt(Dragon::getDamage)
                .average()
                .getAsDouble();
    }
    private static double getHealthAvg(Map<String, Dragon> dragonByName) {
        return dragonByName.values()
                .stream()
                .mapToInt(Dragon::getHealth)
                .average()
                .getAsDouble();
    }
    private static double getArmorAvg(Map<String, Dragon> dragonByName) {
        return dragonByName.values()
                .stream()
                .mapToInt(Dragon::getArmor)
                .average()
                .getAsDouble();
    }
}
