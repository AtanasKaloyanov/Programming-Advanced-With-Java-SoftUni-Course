package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P11LoggsAgregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> map = new TreeMap<>();

        for (int i = 1; i <= number; i++) {
            String[] array = scanner.nextLine().split(" ");

            String IP = array[0];
            String name = array[1];
            int duration = Integer.parseInt(array[2]);

            map.putIfAbsent(name, new TreeMap<>());
            map.get(name).putIfAbsent(IP, 0);
            map.get(name).put(IP, map.get(name).get(IP) + duration);

        }

        map.entrySet().stream().forEach(entry -> {
            int currentTotalDuration = entry.getValue().values().stream().mapToInt(l -> l).sum();
            System.out.printf("%s: %d ", entry.getKey(), currentTotalDuration);

            List<String> list = new LinkedList<>();

            entry.getValue().entrySet().forEach(internalEntry -> list.add(internalEntry.getKey()));
            System.out.println(list);
        });
    }
}
