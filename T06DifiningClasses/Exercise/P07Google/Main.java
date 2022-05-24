package T06DifiningClasses.Exercise.P07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> map = new LinkedHashMap<>();

//•	"{Name} company {companyName} {department} {salary}"
//•	"{Name} pokemon {pokemonName} {pokemonType}"
//•	"{Name} parents {parentName} {parentBirthday}"
//•	"{Name} children {childName} {childBirthday}"
//•	"{Name} car {carModel} {carSpeed}"

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] array = input.split("\\s+");
            String name = array[0];

            map.putIfAbsent(name, new Person());

            String command = array[1];
            if (command.equals("company")) {

                String companyName = array[2];
                String department = array[3];
                double salary = Double.parseDouble(array[4]);

                Company company = new Company(companyName, department, salary);
                map.get(name).setCompany(company);

            } else if (command.equals("pokemon")) {

                String pokemonName = array[2];
                String pokemonType = array[3];

                Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                map.get(name).getPokemonList().add(pokemon);

            } else if (command.equals("parents")) {

                String parentName = array[2];
                String parentBirthday = array[3];

                Parents parents = new Parents(parentName, parentBirthday);
                map.get(name).getParentsList().add(parents);

            } else if (command.equals("children")) {

                String childName = array[2];
                String childBirthday = array[3];

                Children children = new Children(childName, childBirthday);
                map.get(name).getChildrenList().add(children);

            } else if (command.equals("car")) {

                String carModel = array[2];
                double carSpeed = Double.parseDouble(array[3]);

                Car car = new Car(carModel, carSpeed);
                map.get(name).setCar(car);
            }

                input = scanner.nextLine();
        }

        String printName = scanner.nextLine();

        System.out.println(printName);
        Person searchedPerson = map.get(printName);
        System.out.println(searchedPerson.toString());
    }
}
