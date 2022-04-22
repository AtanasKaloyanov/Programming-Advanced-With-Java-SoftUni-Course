package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currenChar = input.charAt(i);
            if (currenChar == '(') {
                stack.push(i);
            } else if (currenChar == ')'){
                int openBracketPosition = stack.peek();
                int closingBracketPosition = i;
                String expressionWithBrackets = input.substring(openBracketPosition, closingBracketPosition + 1);
                System.out.println(expressionWithBrackets);
                stack.pop();
            }
        }
    }
}

//   1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

//  (2 + 3)
//  (3 + 1)
//  (2 - (2 + 3) * 4 / (3 + 1))