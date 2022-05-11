package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        Map<String, String> map = new LinkedHashMap<>();
        String name = null;

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            counter++;
            if (counter % 2 != 0) {
                 name = input;
                 map.put(name, null);
            } else {
               String email = input;
               String[] array = input.split("\\.");
               String lastElement = array[array.length - 1];

               if (!lastElement.equals("us") && !lastElement.equals("uk") && !lastElement.equals("com")) {
                   map.put(name, email);
               } else {
                   map.remove(name);
               }
               
            }

            input = scanner.nextLine();
        }

        map.forEach( (key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
