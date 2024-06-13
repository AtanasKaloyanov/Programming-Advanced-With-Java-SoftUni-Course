package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        // 1. Input reading and adding to a map

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, String> numbersByPeople = new LinkedHashMap<>();

        while (!line.equals("search")) {
            String[] array = line.split("-");
            String name = array[0];
            String number = array[1];
            numbersByPeople.put(name, number);
            line = scanner.nextLine();
        }

        // 2. Names reading and message printing
        line = scanner.nextLine();
        while (!line.equals("stop")) {
            String number = numbersByPeople.get(line);
            messagePrinting(line, number);
            line = scanner.nextLine();
        }
    }

    private static void messagePrinting(String line, String number) {
        if (number == null) {
            System.out.printf("Contact %s does not exist.\n", line);
        } else {
            System.out.printf("%s -> %s\n", line, number);
        }
    }
}
