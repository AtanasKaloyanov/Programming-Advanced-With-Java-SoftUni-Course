package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                stack.push(input);
                System.out.println(stack.peek());
            }
            input = scanner.nextLine();
        }

        //https//softuni.bg/
        //back
        //https//softuni.bg/trainings/courses
        //back
        //https//softuni.bg/trainings/2056
        //back
        //https//softuni.bg/trainings/live
        //https//softuni.bg/trainings/live/details
        //Home

        //https//softuni.bg/
        //no previous URLs
        //https//softuni.bg/trainings/courses
        //https//softuni.bg/
        //https//softuni.bg/trainings/2056
        //https//softuni.bg/
        //https//softuni.bg/trainings/live
        //https//softuni.bg/trainings/live/details

    }
}
