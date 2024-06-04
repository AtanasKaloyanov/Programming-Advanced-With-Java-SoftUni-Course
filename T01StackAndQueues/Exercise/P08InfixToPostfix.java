package T01StackAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String[] symbols = scanner.nextLine().split(" ");

        // 2. Creating a map and adding as keys operators. The operator have different priorities as keys.
        // "(" and ")" should have priority 1,
        // "+" and "-" should have priority 2 and
        // "*" and "/" - priority 3
        Map<String, Integer> prioritiesBySymbols = new HashMap<>();
        prioritiesBySymbols.put("(", 1);
        prioritiesBySymbols.put(")", 1);
        prioritiesBySymbols.put("+", 2);
        prioritiesBySymbols.put("-", 2);
        prioritiesBySymbols.put("*", 3);
        prioritiesBySymbols.put("/", 3);

        // 3. Creating another 2 data structures - a stack for pushing the operator
        // and a queue for offering the output. Looping through every symbol from the input
        // via foreach cycle and solving 4 cases:
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        for (String symbol : symbols) {
            switch (symbol) {
                // 3.1. If the current symbol is an open bracket - pushing into the stack with the operator
                case "(":
                    operatorsStack.push(symbol);
                    break;
                // 3.2. If the current symbol is a closed bracket:
                // 3.2.1. Popping from the operators and offering to the output while the current element
                // isn't an open bracket
                case ")":
                    String operatorPeek = operatorsStack.peek();
                    while (!operatorPeek.equals("(")) {
                        String topOperator = operatorsStack.pop();
                        outputQueue.offer(topOperator);
                        operatorPeek = operatorsStack.peek();
                    }
                    // 3.2.2. Finally popping from the operators. The element that is erased is an open bracket
                    operatorsStack.pop();
                    break;

                // 3.3. If the current symbol is "+", "-", "*" or "/" :
                case "+":
                case "-":
                case "*":
                case "/":

                    // 3.3.1. Popping from the operators and offering to the output while:
                    // 1. The operator's stack has 1 or more elements
                    // 2. The priority of the operator's peek is greater or equals than the priority of the
                    // output's peek
                    while (!operatorsStack.isEmpty() && prioritiesBySymbols.get(operatorsStack.peek()) >= prioritiesBySymbols.get(symbol)) {
                        String currentOperator = operatorsStack.pop();
                        outputQueue.offer(currentOperator);
                    }

                    // 3.3.2. Pushing the symbol to the operator's stack
                    operatorsStack.push(symbol);
                    break;

                // 3.4. Default: If the current symbol is a number or a letter -
                // offering it to the output:
                default:
                    outputQueue.offer(symbol);
                    break;
            }
        }

        // 4. Finally popping every element from the operators and offering it to the
        // output and printing the output:
        outputQueue.addAll(operatorsStack);
        for (String element : outputQueue) {
            System.out.print(element + " ");
        }
    }
}
/*
 Input 1:                Operators                Output

 5 / (3 + 2)
 5                                                 5
 /                           /                     5
 (                        (  /                     5
 3                        (  /                     5 3
 +                      + (  /                     5 3
 2                      + (  /                     5 3 2
 )                           /                     5 3 2 +

 Output 1:  5 3 2 + /


 Input 2:                Operators                Output

 1 + 2 + 3
 1                                                1
 +                        +                       1
 2                        +                       1 2
 +                        +                       1 2 +
 3                        +                       1 2 + 3

 Output 2:               1 2 + 3 +

  Input 3:                  Operators                Output

  7 + 13 / ( 12 - 4 )
  7                                                   7
  +                             +                     7
  13                            +                     7 13
  /                           / +                     7 13
  (                         ( / +                     7 13
  12                        ( / +                     7 13 12
  -                       - ( / +                     7 13 12
  4                       - ( / +                     7 13 12 4
  )                           / +                     7 13 12 4 -

  Output 3:                7 13 12 4 - / +

  Input 4:                  Operators                Output

  (3 + x) - y
  (                            (
  3                            (                      3
  +                          + (                      3
  x                          + (                      3 x
  )                                                   3 x +
  -                           -                       3 x +
  y                           -                       3 x + y

  Output 4:     3 x + y -

 */