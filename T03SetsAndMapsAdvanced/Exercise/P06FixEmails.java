package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P06FixEmails {
    public static void main(String[] args) {
        // 1. Adding the input into a map
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, String> emailByName = new LinkedHashMap<>();
        while (!line.equals("stop")) {
            String name = line;
            String email = scanner.nextLine();
            String[] array = email.split("\\.");
            String domain = array[array.length - 1].toLowerCase();

            if (isCorrectEmail(domain)) {
                emailByName.put(name, email);
            }
            line = scanner.nextLine();
        }

        // 2. Output printing:
        emailByName.forEach( (key, vaue) ->
                System.out.printf("%s -> %s\n", key, vaue));
    }

    private static boolean isCorrectEmail(String domain) {
        return (!domain.equals("us")) && (!domain.equals("uk")) && (!domain.equals("com"));
    }
}
