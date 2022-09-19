package T11ExamPreparation.E13December2019;

import java.util.*;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> materials = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> magicElements = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(materials);

        Map<String, Integer> map = new TreeMap<>();
        map.put("Bicycle", 0);
        map.put("Doll", 0);
        map.put("Teddy bear", 0);
        map.put("Wooden train", 0);

        while (!materials.isEmpty() && !magicElements.isEmpty()) {

            int materialsFirstElement = materials.get(0);
            int magicElementsFirstElement = magicElements.get(0);
            int product = materialsFirstElement * magicElementsFirstElement;

            switch (product) {
                case 150:
                    materials.remove(0);
                    magicElements.remove(0);
                    map.put("Doll", map.get("Doll") + 1);
                    break;

                case 250:
                    materials.remove(0);
                    magicElements.remove(0);
                    map.put("Wooden train", map.get("Wooden train") + 1);
                    break;

                case 300:
                    materials.remove(0);
                    magicElements.remove(0);
                    map.put("Teddy bear", map.get("Teddy bear") + 1);
                    break;

                case 400:
                    materials.remove(0);
                    magicElements.remove(0);
                    map.put("Bicycle", map.get("Bicycle") + 1);
                    break;

                default:
                    if (product < 0) {
                        int sum = materialsFirstElement + magicElementsFirstElement;
                        materials.remove(0);
                        magicElements.remove(0);
                        Collections.reverse(materials);
                        materials.add(sum);
                        Collections.reverse(materials);
                    } else if (product == 0) {
                        if (materialsFirstElement == 0) {
                            materials.remove(0);
                        }

                        if (magicElementsFirstElement == 0) {
                            magicElements.remove(0);
                        }

                    } else if (product > 0) {
                        magicElements.remove(0);
                        materials.set(0, materials.get(0) + 15);
                    }

                    break;
            }

        }

        boolean condition = false;

        if (map.get("Doll") != 0 && map.get("Wooden train") != 0) {
            condition = true;
        }

        if (map.get("Bicycle") != 0 && map.get("Teddy bear") != 0) {
            condition = true;
        }

        if (condition) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.printf("Materials left: %s%n", materials.toString().replaceAll("[\\[\\]]", ""));
        }

        if (!magicElements.isEmpty()) {
            System.out.printf("Magic left: %s%n", magicElements.toString().replaceAll("[\\[\\]]", ""));
        }

        map.entrySet().stream().filter(entry -> entry.getValue() != 0).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
