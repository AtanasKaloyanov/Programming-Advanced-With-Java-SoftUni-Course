package T01StackAndQueues.Lab;


import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backPages = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();

        String input = scanner.nextLine();
        String currentUrl = "";

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (backPages.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {
                    forwardPages.push(currentUrl);
                    currentUrl = backPages.pop();
                    System.out.println(currentUrl);
                }

            } else if (input.equals("forward")) {
                if (forwardPages.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    backPages.push(currentUrl);
                    currentUrl = forwardPages.pop();
                    System.out.println(currentUrl);
                }

            } else {
                if (!currentUrl.equals("")) {
                    backPages.push(currentUrl);
                }
                forwardPages.clear();
                currentUrl = input;
                System.out.println(currentUrl);
            }

            input = scanner.nextLine();
        }
    }
}
