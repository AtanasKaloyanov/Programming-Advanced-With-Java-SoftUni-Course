package T06DifiningClasses.Exercise.P01OpinionPollSecondSolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int peopleNumber = Integer.parseInt(scanner.nextLine());

        List<Person> list = new ArrayList<>();

        for (int i = 1; i <= peopleNumber ; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            String name = array[0];
            int age = Integer.parseInt(array[1]);

            if (age > 30) {
                Person person = new Person(name, age);
                list.add(person);
            }

        }

        list.sort(Comparator.comparing(person -> person.getName()));
        list.stream().forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));
    }
}
