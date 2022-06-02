package T09IteratorsAndComparators.Exercise.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] array = input.split("\\s+");
            String name = array[0];
            int age = Integer.parseInt(array[1]);
            String town = array[2];

            Person person = new Person(name, age, town);
            personList.add(person);

            input = scanner.nextLine();
        }

        int number = Integer.parseInt(scanner.nextLine());
        Person comparePerson = personList.get(number - 1);

        int counter = 0;
        for (Person currentPerson : personList) {
            if (comparePerson.compareTo(currentPerson) == 0) {
                counter++;
            }
        }

        int allPeopleNumber = personList.size();
        if (counter == 1) {
            System.out.println("No matches");
        } else {
            int notEqualPeople = allPeopleNumber - counter;
            System.out.printf("%d %d %d", counter, notEqualPeople, allPeopleNumber);
        }
    }
}
