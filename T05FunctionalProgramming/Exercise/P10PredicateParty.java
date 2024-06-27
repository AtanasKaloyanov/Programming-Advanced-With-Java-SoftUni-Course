package T05FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        List<String> people = readList(scanner);

        // 2. Commands implementation:
        String line = scanner.nextLine();
        while (!line.equals("Party!")) {
            String[] array = line.split(" ");
            String command = array[0];
            String using = array[1];
            String circumstance = array[2];

            Predicate<String> predicate;
            if (command.equals("Double")) {
                predicate = conditionImplementation(using, circumstance);
                List<String> doubledPeople = getPeopleByCondition(people, predicate);
                people.addAll(doubledPeople);
            } else if (command.equals("Remove")) {
                predicate = conditionImplementation(using, circumstance);
                people.removeIf(predicate);
            }

            line = scanner.nextLine();
        }

        // 3. People sorting:
        Collections.sort(people);

        // 4. Output printing:
        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String peopleToTheParty = people.toString().replaceAll("[\\[\\]]", "");
            System.out.printf("%s are going to the party!", peopleToTheParty);
        }
    }

    private static List<String> getPeopleByCondition(List<String> people, Predicate<String> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static Predicate<String> conditionImplementation(String using, String circumstance) {
        Predicate<String> predicate = null;
        switch (using) {
            case "StartsWith":
                predicate = word -> word.startsWith(circumstance);
                break;
            case "EndsWith":
                predicate = word -> word.endsWith(circumstance);
                break;
            case "Length":
                int l = Integer.parseInt(circumstance);
                predicate = word -> word.length() == l;
                break;
        }
        return predicate;
    }

    private static List<String> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
    }
}
