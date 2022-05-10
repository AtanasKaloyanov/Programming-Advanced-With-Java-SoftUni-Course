package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 1; i <= number ; i++) {
            String currentUsername = scanner.nextLine();
            usernames.add(currentUsername);
        }

        for (String currentUsername : usernames) {
            System.out.println(currentUsername);
        }
    }
}
