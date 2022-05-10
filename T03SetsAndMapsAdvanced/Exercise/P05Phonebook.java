package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {

            String[] information = input.split("-");
            String name = information[0];
            String phoneNumber = information[1];

            map.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        String secondInput = scanner.nextLine();
        while(!secondInput.equals("stop")) {

            if (map.containsKey(secondInput)) {
                System.out.printf("%s -> %s%n", secondInput, map.get(secondInput));
            } else {
                System.out.printf("Contact %s does not exist.%n", secondInput);
            }

            secondInput = scanner.nextLine();
        }
    }
}
