package T03SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> occurrencesBySymbols = new TreeMap<>();
        char[] chars = scanner.nextLine().toCharArray();

        // 2. Adding to the map
        for (char charE : chars) {
            occurrencesBySymbols.putIfAbsent(charE, 0);
            int oldOcc = occurrencesBySymbols.get(charE);
            occurrencesBySymbols.put(charE, oldOcc + 1);
        }

        // 3. Output printing:
        occurrencesBySymbols.forEach( (key, value) ->
                System.out.printf("%c: %d time/s\n", key, value)) ;
    }
}
