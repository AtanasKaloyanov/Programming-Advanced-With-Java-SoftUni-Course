package T05FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicatePartySecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] array = input.split(" ");
            String command = array[0];

            switch (command) {
                case "Remove":
                    list.removeIf(predicate(array));
                    break;

                case "Double":
                    List<String> newList = new ArrayList<>();
                    list.stream().filter(predicate(array)).forEach(element -> newList.add(element));
                    list.addAll(newList);
                    break;
            }

            input = scanner.nextLine();
        }

        Collections.sort(list);
        if (list.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(list.toString().replaceAll("[\\[\\]]", "") + " are going to the party!");
        }
    }

    public static Predicate<String> predicate(String[] array) {
        Predicate<String> predicate;

        String condition = array[1];
        switch (condition) {
            case "StartsWith":
                predicate = name -> name.startsWith(array[2]);
                break;

            case "EndsWith":
                predicate = name -> name.endsWith(array[2]);
                break;

            case "Length":
                predicate = name -> name.length() == Integer.parseInt(array[2]);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + condition);
        }

        return predicate;
    }
}
