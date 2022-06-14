package T11ExamPreparation.E05August2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(ingredients);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Biscuit", 0);
        map.put("Cake", 0);
        map.put("Pie", 0);
        map.put("Pastry", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int firstLiquid = liquids.get(0);
            int firstIngredient = ingredients.get(0);

            int sum = firstLiquid + firstIngredient;

            switch (sum) {

                case 25:
                    map.put("Biscuit", map.get("Biscuit") + 1);
                    liquids.remove(0);
                    ingredients.remove(0);
                    break;

                case 50:
                    map.put("Cake", map.get("Cake") + 1);
                    liquids.remove(0);
                    ingredients.remove(0);
                    break;

                case 100:
                    map.put("Pie", map.get("Pie") + 1);
                    liquids.remove(0);
                    ingredients.remove(0);
                    break;

                case 75:
                    map.put("Pastry", map.get("Pastry") + 1);
                    liquids.remove(0);
                    ingredients.remove(0);
                    break;

                default:
                    liquids.remove(0);
                    ingredients.set(0, ingredients.get(0) + 3);
            }
        }

        boolean condition = true;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int currentValue = entry.getValue();
            if (currentValue == 0) {
                condition = false;
                break;
            }
        }

        if (condition) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }


        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s%n", liquids.toString().replaceAll("[\\[\\]]", ""));
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s%n", ingredients.toString().replaceAll("[\\[\\]]", ""));
        }

        map.entrySet().stream().forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));
    }
}
