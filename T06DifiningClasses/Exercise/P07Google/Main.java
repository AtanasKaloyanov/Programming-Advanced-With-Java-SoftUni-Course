package T06DifiningClasses.Exercise.P07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, Person> peopleByName = new HashMap<>();
        while (!line.equals("End")) {
            String[] array = line.split(" ");
            // 2. Creating a person and adding it his / hers fields:
            String personName = array[0];
            peopleByName.putIfAbsent(personName, new Person(personName));
            Person person = peopleByName.get(personName);

            String fieldNameOrModel = array[2];
            String fieldName = array[1];

            switch (fieldName) {
                case "company":
                    String department = array[3];
                    double salary = Double.parseDouble(array[4]);
                    Company company = new Company(fieldNameOrModel, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    String type = array[3];
                    Pokemon pokemon = new Pokemon(fieldNameOrModel, type);
                    person.getPokemons().add(pokemon);
                    break;
                case "parents":
                    String birthday = array[3];
                    Parent parent = new Parent(fieldNameOrModel, birthday);
                    person.getParents().add(parent);
                    break;
                case "children":
                    String birthday2 = array[3];
                    Child child = new Child(fieldNameOrModel, birthday2);
                    person.getChildren().add(child);
                    break;
                case "car":
                    int speed = Integer.parseInt(array[3]);
                    Car car = new Car(fieldNameOrModel, speed);
                    person.setCar(car);
                    break;
            }

            line = scanner.nextLine();
        }

        // 3. Searched name:
        String name = scanner.nextLine();
        Person person = peopleByName.get(name);
        System.out.print(person);
    }
}
