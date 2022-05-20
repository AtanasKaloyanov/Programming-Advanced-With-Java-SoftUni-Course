package T05FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {

    static List<String> list = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] array = input.split(" ");
            switch (array[0]) {
                case "Double":
                    addOneMore(getPredicate(array));
                    break;

                case "Remove":
                    removeName(getPredicate(array));
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

    private static void removeName(Predicate<String> predicate) {
        list.removeIf(predicate);
    }

    public static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        list.stream().filter(predicate).forEach(element -> namesToAdd.add(element));
        list.addAll(namesToAdd);
    }

    public static Predicate<String> getPredicate(String[] array) {
        Predicate<String> predicate;

        if (array[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(array[2]);
        } else if (array[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(array[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(array[2]);
        }

        return predicate;
    }
}
