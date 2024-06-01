package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int numberCommands = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String[]> arrays = new ArrayDeque<>();
        ArrayDeque<String> lastDeleted = new ArrayDeque<>();

        // 2. Commands implementation
        for (int i = 1; i <= numberCommands; i++) {
            String[] array = scanner.nextLine().split(" ");
            String currentCommand = array[0];

            switch (currentCommand) {
                case "1":
                    String text = array[1];
                    sb.append(text);
                    arrays.push(array);
                    break;

                case "2":
                    int count = Integer.parseInt(array[1]);
                    String deleted = sb.substring(sb.length() - count);
                    sb.delete(sb.length() - count, sb.length());
                    arrays.push(array);
                    lastDeleted.push(deleted);
                    break;

                case "3":
                    int index = Integer.parseInt(array[1]);
                    char lastElement = sb.charAt(index - 1);
                    System.out.println(lastElement);
                    break;

                case "4":
                    String[] lastArray = arrays.pop();
                    String lastCommand = lastArray[0];

                    if (lastCommand.equals("1")) {
                        String lastAdded = lastArray[1];
                        int lastAddedStartIndex = sb.toString().length() - lastAdded.length();
                        sb.delete(lastAddedStartIndex, sb.length());
                    } else if (lastCommand.equals("2")) {
                        String lastErased = lastDeleted.pop();
                        sb.append(lastErased);
                    }
                    break;
            }

        }
    }
}
