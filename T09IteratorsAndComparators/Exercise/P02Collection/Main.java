package T09IteratorsAndComparators.Exercise.P02Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(inputList);

        String secondInput = scanner.nextLine();

        while (!secondInput.equals("END")) {

            switch (secondInput) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;

                case "Print":
                    listyIterator.print();
                    break;

                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;

                case "PrintAll":
                   listyIterator.pritAll();
            }
            secondInput = scanner.nextLine();

        }
    }
}
