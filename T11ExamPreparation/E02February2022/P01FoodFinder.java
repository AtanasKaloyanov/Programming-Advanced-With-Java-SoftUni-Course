package T11ExamPreparation.E02February2022;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class P01FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> vowels = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> consonants = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        Collections.reverse(consonants);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("pear", 0);
        map.put("flour", 0);
        map.put("pork", 0);
        map.put("olive", 0);

        List<String> list = new ArrayList<>();
        List <String> secondList = new ArrayList<>();

        while (!consonants.isEmpty()) {
            String firstVowelLetter = vowels.get(0);
            String firstConsonantLetter = consonants.get(0);

            map.entrySet().stream().forEach(entry -> {
                boolean isTheVowelInMap = entry.getKey().contains(firstVowelLetter);
                boolean isTheConsonantInTheMap = entry.getKey().contains(firstConsonantLetter);
                if (isTheVowelInMap && !list.contains(firstVowelLetter)) {
                    map.put(entry.getKey(), entry.getValue() + 1);
                }

                if (isTheConsonantInTheMap && !secondList.contains(firstConsonantLetter)) {
                    map.put(entry.getKey(), entry.getValue() + 1);
                }
            });

            vowels.remove(0);
            vowels.add(firstVowelLetter);
            consonants.remove(0);

            if (!list.contains(firstVowelLetter)) {
                list.add(firstVowelLetter);
            }

            if (!secondList.contains(firstConsonantLetter)) {
                secondList.add(firstConsonantLetter);
            }

        }

        AtomicInteger number = new AtomicInteger();
        map.entrySet().stream().forEach(entry -> {
            int a = entry.getKey().length();
            if (a == entry.getValue()) {
                number.getAndIncrement();
            }
        });

        System.out.printf("Words found: %s%n", number);
        map.entrySet().stream().forEach(entry -> {
            int b = entry.getKey().length();
            if (b == entry.getValue()) {
                System.out.println(entry.getKey());
            }
        });

    }
}
