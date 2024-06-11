package T03SetsAndMapsAdvanced.Lab;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        // 1. Adding the guest to a TreeSet
        Scanner scanner = new Scanner(System.in);
        Set<String> guests = new TreeSet<>();

        String input = scanner.nextLine();
        while (!input.equals("PARTY")) {
            guests.add(input);

            input = scanner.nextLine();
        }

        // 2. Removing the guests that come
        String secondInput = scanner.nextLine();
        while (!secondInput.equals("END")) {
            guests.remove(secondInput);

            secondInput = scanner.nextLine();
        }

        // 3. Printing the guests
        System.out.println(guests.size());
        for (String currentGuest : guests) {
            System.out.println(currentGuest);
        }
    }
}
