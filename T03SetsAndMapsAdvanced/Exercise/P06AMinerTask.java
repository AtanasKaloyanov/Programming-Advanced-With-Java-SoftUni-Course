package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> map = new LinkedHashMap<>();

        int counter = 0;
        String input = scanner.nextLine();
        String resource = "";

        while (!input.equals("stop")) {
            counter++;

            if (counter % 2 != 0) {
               resource = input;
               map.putIfAbsent(resource, 0);

            } else {
                int quantity = Integer.parseInt(input);
                map.put(resource, map.get(resource) + quantity);
            }

            input= scanner.nextLine();
        }

        System.out.println();

        map.forEach( (key, value) -> System.out.printf("%s -> %s%n", key, value));
    }
}
