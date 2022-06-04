package T09IteratorsAndComparators.Exercise.P04Froggy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> givenList = Arrays.stream(scanner.nextLine().split(", "))
                .map(element -> Integer.parseInt(element))
                .collect(Collectors.toList());

        String end = scanner.nextLine();

        Lake lake = new Lake(givenList);
        Iterator<Integer> it = lake.iterator();

        List<Integer> printList = new ArrayList<>();

        while(it.hasNext()) {
            printList.add(it.next());
        }

        while (lake.hasNext2()) {
                printList.add(lake.next2());
        }

        System.out.println(String.join(", ", printList.toString().replaceAll("[\\[\\]]", "")));
    }
}
