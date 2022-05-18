package T05FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> namesAndAges = new LinkedHashMap<>();

        for (int i = 1; i <= number; i++) {
            String[] array = scanner.nextLine().split(", ");
            String name = array[0];
            int age = Integer.parseInt(array[1]);

            namesAndAges.put(name, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate;

        if (condition.equals("younger")) {
            filterPredicate = (personAge, conditionAge) -> personAge <= conditionAge;
        } else {
            filterPredicate = (personAge, conditionAge) -> personAge >= conditionAge;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;

        switch (format) {
            case "name":
                printConsumer = entry -> System.out.println(entry.getKey());
                break;

            case "age":
                printConsumer = entry -> System.out.println(entry.getValue());
                break;

            case "name age":
            printConsumer = entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + format);
        }

        namesAndAges.entrySet().stream()
                .filter(person -> filterPredicate.test(person.getValue(), age))
                .forEach(printConsumer);
    }
}
