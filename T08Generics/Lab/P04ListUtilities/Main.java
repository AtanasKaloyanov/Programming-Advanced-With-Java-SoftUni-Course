package T08Generics.Lab.P04ListUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Creating an ArrayList and getting the least element and the greatest
        // via the static methods getMin() and getMax()
        List<Integer> numbers = new ArrayList<>(List.of(10, 100, 7, 20));
        // 1.1. getMin()
        Integer leastNumber = ListUtils.getMin(numbers);
        System.out.println(leastNumber);
        // 1.2. getMax()
        Integer greatestNumber = ListUtils.getMax(numbers);
        System.out.println(greatestNumber);

        // 2. The same algorithm but with String
        List<String> words = new ArrayList<>(Arrays.asList("B", "A", "D", "Y", "C"));
        // 2.1 getMin()
        String firstWord = ListUtils.getMin(words);
        System.out.println(firstWord);
        // 2.2. getMax()
        String lastWord = ListUtils.getMax(words);
        System.out.println(lastWord);
    }
}
