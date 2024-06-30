package T06DifiningClasses.Exercise.P01OpinionPoll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Adding the people into a List:
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split(" ");
            int years = Integer.parseInt(info[1]);
            if (years > 30) {
                String name = info[0];
                Person person = new Person(name, years);
                people.add(person);
            }
        }

        // 3. Sorting and printing:
        Collections.sort(people);
        people.forEach(System.out::println);
    }
}
