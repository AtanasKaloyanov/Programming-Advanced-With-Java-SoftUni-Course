package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 2. Looping through the symbols. If a current symbol is an open bracket adding
        // its index to a stack. If the current symbol is a closing bracket printing the
        // current expression using substring method. The starting symbol is the peek of the stack.
        // The last step is the removing of this index via popping:
        ArrayDeque<Integer> openBracketsIndeces = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(') {
                openBracketsIndeces.push(i);
            } else if (currentChar == ')') {
                int startingIndex = openBracketsIndeces.pop();
                String currentExpression = input.substring(startingIndex, i + 1);
                System.out.println(currentExpression);
            }
        }
    }
}
