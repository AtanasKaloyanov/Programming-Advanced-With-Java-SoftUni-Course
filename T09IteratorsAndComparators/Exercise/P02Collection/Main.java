package T09IteratorsAndComparators.Exercise.P02Collection;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Reading a line and until End command another commands implementation:
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        ListyIterator listIterator = null;
        while (!line.equals("END")) {
            String[] array = line.split(" ");
            String command = array[0];

            switch (command) {
                case "Create":
                    String[] elements = new String[array.length - 1];
                    for (int i = 1; i < array.length; i++) {
                        String currentElement = array[i];
                        elements[i - 1] = currentElement;
                    }

                    listIterator = new ListyIterator(elements);
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "Print":
                    listIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "PrintAll":
                    listIterator.printAll();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
