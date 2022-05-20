package T05FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        List<String> secondList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] array = input.split(";");
            String command = array[0];

            switch (command) {
                case "Add filter":
                    list.stream().filter(predicate(array)).forEach(element -> secondList.add(element));
                    list.removeIf(predicate(array));
                    break;

                case "Remove filter":
          secondList.stream().filter(predicate(array)).forEach(element -> list.add(element));
                    break;

                    
            }

            input = scanner.nextLine();
        }

        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }

    public static Predicate<String> predicate(String[] array) {
        Predicate<String> predicate;

        String condition = array[1];
        switch (condition) {
            case "Starts with":
                predicate = name -> name.startsWith(array[2]);

                break;

            case "Ends with":
                predicate = name -> name.endsWith(array[2]);
                break;

            case "Length":
                predicate = name -> name.length() == Integer.parseInt(array[2]);
                break;

            case "Contains":
                predicate = name -> name.contains(array[2]);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + condition);
        }

        return predicate;
    }
}
