package T09IteratorsAndComparators.Exercise.P09LinkedListTraversal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Number command reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. LinkedList initialization and for cycle algorithm
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String command = array[0];
            Integer number = Integer.parseInt(array[1]);

            if (command.equals("Add")) {
                linkedList.addLast(number);
            } else if (command.equals("Remove")) {
                linkedList.removeFirst(number);
            }
        }

        // 3. Output printing:
        int elements = linkedList.getSize();
        System.out.println(elements);
        linkedList.forEach( (element) -> System.out.print(element + " "));
    }

}

        /*
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        list.addLast("E");
        list.removeFirst("C");

        list.forEach(System.out::println);
         */

