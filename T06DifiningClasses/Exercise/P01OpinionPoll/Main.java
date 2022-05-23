package T06DifiningClasses.Exercise.P01OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 1; i <= numberPeople ; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            String currentName = array[0];
            int currentAge = Integer.parseInt(array[1]);

            Person person = new Person(currentName, currentAge);
            map.put(person.getName(), person.getAge());
        }

        map.entrySet().stream().filter(entry -> entry.getValue() > 30).forEach(entry -> System.out.printf("%s - %d%n", entry.getKey(), entry.getValue()));
    }
}
