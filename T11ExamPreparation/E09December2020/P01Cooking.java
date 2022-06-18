package T11ExamPreparation.E09December2020;

import java.util.*;
import java.util.stream.Collectors;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> liquids = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> ingredients = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(ingredients);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Bread", 0);
        map.put("Cake", 0);
        map.put("Fruit Pie", 0);
        map.put("Pastry", 0);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int firstLiquid = liquids.get(0);
            int firstIngredient = ingredients.get(0);

            int sum = firstLiquid + firstIngredient;

            switch (sum) {
                case 25:
                    map.put("Bread", map.get("Bread") + 1);
                    liquids.remove(0);
                    ingredients.remove(0);
                    break;

                case 50:
                    map.put("Cake", map.get("Cake") + 1);
                    liquids.remove(0);
                    ingredients.remove(0);
                    break;

                case 75:
                    map.put("Pastry", map.get("Pastry") + 1);
                    liquids.remove(0);
                    ingredients.remove(0);
                    break;

                case 100:
                    map.put("Fruit Pie", map.get("Fruit Pie") + 1);
                    liquids.remove(0);
                    ingredients.remove(0);
                    break;

                default:
                    liquids.remove(0);
                    ingredients.set(0, ingredients.get(0) + 3);
                    break;
            }
        }
        boolean enoughFood = true;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int currentNumber = entry.getValue();
            if (currentNumber == 0) {
                enoughFood = false;
            }
        }

        if (enoughFood) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
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

        map.entrySet().forEach(element -> System.out.printf("%s: %d%n", element.getKey(), element.getValue()));
    }
}
