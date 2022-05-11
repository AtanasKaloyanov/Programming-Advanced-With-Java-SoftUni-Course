package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> map = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {

            String[] array = input.split("=");
            String IPPlus = array[1];
            String[] secondArray = IPPlus.split(" ");
            String IP = secondArray[0];

            String username = array[3];

            map.putIfAbsent(username, new LinkedHashMap<>());
            map.get(username).putIfAbsent(IP, 0);
            map.get(username).put(IP, map.get(username).get(IP) + 1);

            input = scanner.nextLine();
        }

        map.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            int counter = 0;
            for (Map.Entry<String, Integer> iternalEntry : value.entrySet()) {
                counter++;
                System.out.printf("%s => %d", iternalEntry.getKey(), iternalEntry.getValue());
                if (counter == value.size()) {
                    System.out.println(".");
                } else {
                    System.out.print(", ");
                }
            }

        });
    }
}
