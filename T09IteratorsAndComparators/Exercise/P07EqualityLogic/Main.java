package T09IteratorsAndComparators.Exercise.P07EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
    // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> personTreeSet = new TreeSet<>();
        Set<Person> personHashSet = new HashSet<>();

        // 2. Reading n people via for cycle:
        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String name = array[0];
            int age = Integer.parseInt(array[1]);
            Person person = new Person(name, age);
            personTreeSet.add(person);
            personHashSet.add(person);
        }

        // 3. Output printing - the size of the collections:
        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());

    }
}
