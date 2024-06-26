package T05FunctionalProgramming.Lab;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }

    }
    public static void main(String[] args) {
        // 1. Input reading and adding it to a map:
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= times; i++) {
            String[] array = scanner.nextLine().split(", ");
            String name = array[0];
            int age = Integer.parseInt(array[1]);
            Person person = new Person(name, age);
            people.add(person);
        }

        // 2. Reading older or younger, age and format:
        String youngerOrOlder = scanner.nextLine();
        int givenAge = Integer.parseInt(scanner.nextLine());
        String printFormat = scanner.nextLine();

        // 3. Predicate initializing:

        Predicate<Person> predicate;
        if (youngerOrOlder.equals("younger")) {
            predicate = (person) -> person.getAge() <= givenAge;
        } else {
            predicate = (person) -> person.getAge() >= givenAge;
        }

        // 4. Consumer initializing
        Consumer<Person> printConsumer;
        switch (printFormat) {
            case "name":
                printConsumer = person -> System.out.println(person.getName());
                break;
                
            case "age":
                printConsumer = person -> System.out.println(person.getAge());
                break;
                
            case "name age":
                printConsumer = person -> System.out.printf("%s - %d\n", person.getName(), person.getAge());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + printFormat);
        }

        // 5. Filtering and printing:
        people.stream()
                .filter(predicate)
                .forEach(printConsumer);
    }
}
