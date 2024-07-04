package T06DifiningClasses.Exercise.P09CatLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        // 2. Adding the cats to a map:
        Map<String, Cat> catsByName = new HashMap<>();
        while (!line.equals("End")) {
            String[] array = line.split(" ");
            String breed = array[0];
            String name = array[1];
            double thirdSpecifics = Double.parseDouble(array[2]);

            Cat cat = null;
            switch (breed) {
                case "Siamese":
                    cat = new Siamese(breed, name, thirdSpecifics);
                    break;
                case "Cymric":
                    cat = new Cymric(breed, name, thirdSpecifics);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(breed, name, thirdSpecifics);
                    break;
            }
            catsByName.put(name, cat);
            line = scanner.nextLine();
        }

        // 3. Reading the searchedCatName, Getting the needed object and printing it:
        String searchedCatName = scanner.nextLine();
        Cat cat = catsByName.get(searchedCatName);
        System.out.println(cat);
    }
}

