package T05FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    private static Map<String, Predicate<String>> predicates = new HashMap();

    public static void main(String[] args) {
        // 1, Input reading:
        Scanner scanner = new Scanner(System.in);
        List<String> guests = readList(scanner);

        // 2. While cycle implementation until Print command:
        String line = scanner.nextLine();
        while (!line.equals("Print")) {
            // 2.1. Array reading:
            String[] array = line.split(";");
            String command = array[0];
            String type = array[1];
            String parameter = array[2];

            // 2.2. Predicate implementation:
            Predicate<String> predicate = null;
            switch (type) {
                case "Starts with":
                    predicate = word -> word.startsWith(parameter);
                    break;
                case "Ends with":
                    predicate = word -> word.endsWith(parameter);
                    break;
                case "Length":
                    int givenLength = Integer.parseInt(parameter);
                    predicate = word -> word.length() == givenLength;
                    break;
                case "Contains":
                    predicate = word -> word.contains(parameter);
                    break;
            }

            // 2.3. Adding or removing the predicate
            String typePlusParameter = type + " " + parameter;
            if (command.equals("Remove filter")) {
                predicates.remove(typePlusParameter);
            } else if (command.equals("Add filter")) {
                predicates.put(typePlusParameter, predicate);
            }

            line = scanner.nextLine();
        }

        // 3. Looping through every predicate and filtering the guests:
        predicates.values().forEach( (predicate) -> {
            guests.removeIf(predicate);
        });

        // 4. Printing:
        System.out.println(guests.toString()
                .replaceAll("[\\[\\],]", ""));
    }

    private static List<String> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
    }
}
