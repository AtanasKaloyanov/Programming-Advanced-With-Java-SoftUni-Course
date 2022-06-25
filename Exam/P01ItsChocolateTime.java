package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class P01ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> milk = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Double.parseDouble(element)).collect(Collectors.toList());
        List<Double> cacao = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Double.parseDouble(element)).collect(Collectors.toList());

        Collections.reverse(cacao);

        Map<String, Integer> map = new TreeMap<>();
        map.put("Baking Chocolate", 0);
        map.put("Dark Chocolate", 0);
        map.put("Milk Chocolate", 0);

        while(!milk.isEmpty() && !cacao.isEmpty()) {

            double milkFirstElement = milk.get(0);
            double cacaoFirstElement = cacao.get(0);

            double result = cacaoFirstElement / (milkFirstElement + cacaoFirstElement);
            double percentage = result * 100;

            if (percentage == 30) {
                map.put("Milk Chocolate", map.get("Milk Chocolate") + 1);
                milk.remove(0);
                cacao.remove(0);
            } else if (percentage == 50) {
                map.put("Dark Chocolate", map.get("Dark Chocolate") + 1);
                milk.remove(0);
                cacao.remove(0);
            } else if (percentage == 100) {
                map.put("Baking Chocolate", map.get("Baking Chocolate") + 1);
                milk.remove(0);
                cacao.remove(0);
            } else {
                cacao.remove(0);
                double milkForRemoving = milk.get(0);
                milk.remove(0);
                milk.add(milkForRemoving);
            }
        }

        boolean condition = true;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int currentNumber = entry.getValue();
            if (currentNumber == 0) {
                condition = false;
                break;
            }
        }

        if (condition) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        map.entrySet().stream().filter(element -> element.getValue() != 0).forEach(element -> System.out.printf("# %s --> %d%n", element.getKey(), element.getValue()));
    }
}
