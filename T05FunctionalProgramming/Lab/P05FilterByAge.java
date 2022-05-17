package T05FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

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

        switch (format) {
            case "name":
                if (condition.equals("younger")) {
                    namesAndAges.entrySet().stream()
                            .filter(element -> element.getValue() <= age)
                            .forEach(element -> System.out.println(element.getKey()));
                } else {
                    namesAndAges.entrySet().stream()
                            .filter(element -> element.getValue() >= age)
                            .forEach(element -> System.out.println(element.getKey()));
                }
                break;

            case "age":
                if (condition.equals("younger")) {
                    namesAndAges.entrySet().stream()
                            .filter(element -> element.getValue() <= age)
                            .forEach(element -> System.out.println(element.getValue()));
                } else {
                    namesAndAges.entrySet().stream()
                            .filter(element -> element.getValue() >= age)
                            .forEach(element -> System.out.println(element.getValue()));
                }
                break;

            case "name age":
                if (condition.equals("younger")) {
                    namesAndAges.entrySet().stream()
                            .filter(element -> element.getValue() <= age)
                            .forEach(element -> System.out.printf("%s - %d%n", element.getKey(), element.getValue()));
                } else {
                    namesAndAges.entrySet().stream()
                            .filter(element -> element.getValue() >= age)
                            .forEach(element -> System.out.printf("%s - %d%n", element.getKey(), element.getValue()));
                }
                break;
        }
    }

}
