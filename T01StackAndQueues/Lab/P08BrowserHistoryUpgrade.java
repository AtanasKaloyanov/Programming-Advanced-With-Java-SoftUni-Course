package T01StackAndQueues.Lab;


import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<String> sites = new ArrayDeque<>();
        ArrayDeque<String> nextSites = new ArrayDeque<>();

        // 2. 3 cases: forward and back commands implementation or adding a site
        while (!input.equals("Home")) {
            if (input.equals("forward")) {
                // 2.1. 2 cases: if there isn't a next site => message. In other case -
                // popping from the next sites and adding to the sites
                if (nextSites.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String nextSite = nextSites.pop();
                    sites.push(nextSite);
                    System.out.println(nextSite);
                }
            } else if (input.equals("back")) {
                // 2.2. 2 cases: If there is no backward site => message. In other case
                // popping from the sites and adding to the next sites
                if (sites.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    String nextSite = sites.pop();
                    nextSites.push(nextSite);
                    String currentSite = sites.peek();
                    System.out.println(currentSite);
                }
            } else {
                // 2.3. Adding a new site on the top and clearing all forward pages
                sites.push(input);
                nextSites.clear();
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
