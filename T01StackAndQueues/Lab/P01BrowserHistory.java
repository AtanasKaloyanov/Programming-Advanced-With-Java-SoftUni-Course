package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 2. Printing the current or the previous site using a stack:
        ArrayDeque<String> sites = new ArrayDeque<>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                // 2 case:
                if (sites.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    sites.pop();
                    String currentSite = sites.peek();
                    System.out.println(currentSite);
                }
                // 1 case:
            } else {
                sites.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
