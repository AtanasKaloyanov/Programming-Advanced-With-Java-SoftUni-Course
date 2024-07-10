package T09IteratorsAndComparators.Exercise.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. ArrayList creating and via while cycle adding them to it:
        List<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] array = line.split(" ");
            String name = array[0];
            int age = Integer.parseInt(array[1]);
            String town = array[2];
            Person person = new Person(name, age, town);
            people.add(person);
            line = scanner.nextLine();
        }

        // 2. Index computation, person by this index getting and equalPeople counting:
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Person person = people.get(index);

        int equalPeople = 0;
        for (Person currentPerson : people) {
            if (currentPerson.compareTo(person) == 0) {
                equalPeople++;
            }
        }

        // 3. Result printing - 2 cases:
        String resultMessage = "";
        if (equalPeople == 1) {
            resultMessage = "No matches";
        } else {
            int uniquePeople = people.size() - equalPeople;
            int allPeople = people.size();
            resultMessage = String.format("%d %d %d", equalPeople, uniquePeople, allPeople);
        }
        System.out.println(resultMessage);
    }
}
