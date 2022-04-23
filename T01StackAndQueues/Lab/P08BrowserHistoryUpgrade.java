package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> pages = new ArrayDeque<>();
        ArrayDeque<String> forwardPages = new ArrayDeque<>();
        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (pages.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    pages.pop();
                    String currentUrl = pages.peek();
                    System.out.println(currentUrl);
                }
            } else if (input.equals("forward")) {

            }
                else {
                pages.push(input);
                System.out.println(input);
            }
            input = scanner.nextLine();
        }

    }
}

//back
//https//google.bg/
//https//google.bg/softuni
//back
//forward
//https//google.bg/java/advanced
//back
//forward
//https//google.bg/java/oop
//back
//https//google.bg/java/oop
//Home


//no previous URLs
//https//google.bg/
//https//google.bg/softuni
//https//google.bg/
//https//google.bg/softuni
//https//google.bg/java/advanced
//https//google.bg/softuni
//https//google.bg/java/advanced
//https//google.bg/java/oop
//https//google.bg/java/advanced
//https//google.bg/java/oop

