package T09IteratorsAndComparators.Exercise.P03StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackIterator stackIterator = new StackIterator();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] array = input.split("\\s+");
            String command = array[0];

            switch (command) {
                case "Push":
                    stackIterator.push(input);
                    break;

                case "Pop":
                    if (stackIterator.getStack().size() == 0) {
                        System.out.println("No elements");
                        return;
                    }

                    stackIterator.pop();
                    break;
            }

            input = scanner.nextLine();
        }

            ArrayDeque<Integer> secondStack = new ArrayDeque<>(stackIterator.getStack());
            Iterator<Integer> it = stackIterator.iterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }

            secondStack.forEach(System.out::println);
        }

        // push     1 2 3 4
        //          4 3 2 1

        // push     7 8
        //          8 7 4 3 2 1

    }

