package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCommands = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= numberCommands; i++) {
            String[] array = scanner.nextLine().split(" ");
            String currentCommand = array[0];

            switch (currentCommand) {
                case "1":
                    String text = array[1];
                    stack.push(sb.toString());
                    sb.append(text);
                    break;

                case "2":
                    int count = Integer.parseInt(array[1]);
                    stack.push(sb.toString());
                    sb.delete(sb.length() - count, sb.length());
                    break;

                case "3":
                    int index = Integer.parseInt(array[1]);
                    System.out.println(sb.charAt(index - 1));
                    break;

                case "4":
                    sb = new StringBuilder(stack.pop());
                    break;
            }
        }
    }
}
