package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']' || currentChar == '}'){
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char currentOpenBracket = stack.pop();
                if (currentOpenBracket == '(' && currentChar == ')') {
                    isBalanced = true;
                } else if (currentOpenBracket == '[' && currentChar == ']') {
                    isBalanced = true;
                } else if (currentOpenBracket == '{' && currentChar == '}') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
// {[()]}