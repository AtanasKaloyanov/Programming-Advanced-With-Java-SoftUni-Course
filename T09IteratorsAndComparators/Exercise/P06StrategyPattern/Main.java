package T09IteratorsAndComparators.Exercise.P06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Set<Person> firstSet = new TreeSet<>(new NameComparator());
        Set<Person> secondSet = new TreeSet<>(new AgeComparator());

        for (int i = 1; i <= number ; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            String name = array[0];
            int age = Integer.parseInt(array[1]);

            Person person = new Person(name, age);
            firstSet.add(person);
            secondSet.add(person);
        }

        for (Person person : firstSet) {
            System.out.printf("%s %d%n", person.getName(), person.getAge());
        }

        for (Person person : secondSet) {
            System.out.printf("%s %d%n", person.getName(), person.getAge());
        }
    }
}
