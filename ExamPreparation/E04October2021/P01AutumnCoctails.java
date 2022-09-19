package T11ExamPreparation.E04October2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01AutumnCoctails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> ingr = Arrays.stream(scanner.nextLine().split("\\s+")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> freshnessLevel = Arrays.stream(scanner.nextLine().split("\\s+")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());

        Collections.reverse(freshnessLevel);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Apple Hinny", 0);
        map.put("High Fashion", 0);
        map.put("Pear Sour", 0);
        map.put("The Harvest", 0);

        while (!ingr.isEmpty() && !freshnessLevel.isEmpty()) {
            int firstIngr = ingr.get(0);
            int firstFreshnessLevel = freshnessLevel.get(0);

            if (firstIngr == 0) {
                ingr.remove(0);
                continue;
            }

            int product = firstIngr * firstFreshnessLevel;

            switch (product) {
                case 150:
                    map.put("Pear Sour", map.get("Pear Sour") + 1);
                    ingr.remove(0);
                    freshnessLevel.remove(0);
                    break;

                case 250:
                    map.put("The Harvest", map.get("The Harvest") + 1);
                    ingr.remove(0);
                    freshnessLevel.remove(0);
                    break;

                case 300:
                    map.put("Apple Hinny", map.get("Apple Hinny") + 1);
                    ingr.remove(0);
                    freshnessLevel.remove(0);
                    break;

                case 400:
                    map.put("High Fashion", map.get("High Fashion") + 1);
                    ingr.remove(0);
                    freshnessLevel.remove(0);
                    break;

                //# Apple Hinny --> 2
                // # High Fashion --> 1
                // # Pear Sour --> 2
                // # The Harvest --> 1

                default:
                    freshnessLevel.remove(0);
                    ingr.set(0, ingr.get(0) + 5);
                    int ingrForRemovin = ingr.get(0);
                    ingr.remove(0);
                    ingr.add(ingrForRemovin);
                    break;
            }
        }

        boolean isParty = true;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int numberCoctails = entry.getValue();
            if (numberCoctails == 0) {
                isParty = false;
                break;
            }
        }

        int ingrSum = ingr.stream().mapToInt(element -> element).sum();

        if (isParty) {
            System.out.println("It's party time! The cocktails are ready!");
            if (!ingr.isEmpty()) {
                System.out.printf("Ingredients left: %d%n", ingrSum);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
            }

            //It's party time! The cocktails are ready!
            // # Apple Hinny --> 2
            // # High Fashion --> 1
            // # Pear Sour --> 2
            // # The Harvest --> 1
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
            if (!ingr.isEmpty()) {
                System.out.printf("Ingredients left: %d%n", ingrSum);
            }
            map.entrySet().stream().filter(element -> element.getValue() != 0).forEach(element -> System.out.printf("# %s --> %d%n", element.getKey(), element.getValue()));
        }


    }
}
