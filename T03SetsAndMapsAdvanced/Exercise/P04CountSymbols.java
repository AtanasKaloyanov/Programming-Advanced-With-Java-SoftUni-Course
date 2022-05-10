package T03SetsAndMapsAdvanced.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> map = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            map.putIfAbsent(currentChar, 0);
            map.put(currentChar, map.get(currentChar) + 1);
        }

        map.forEach((key, value) -> System.out.printf("%c: %d time/s%n", key, value));
    }
}
