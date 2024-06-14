package T03SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        // 1. Input reading and adding the information into a map
        Scanner scanner = new Scanner(System.in);

        //   user         ip      count
        Map<String, Map<String, Integer>> countsByIpMapByUsers = new TreeMap<>();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] array = line.split("=");
            String ip = array[1].split(" ")[0];
            String user = array[array.length - 1];
            countsByIpMapByUsers.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> countsByIp = countsByIpMapByUsers.get(user);
            countsByIp.putIfAbsent(ip, 0);
            int oldCount = countsByIp.get(ip);
            countsByIp.put(ip, oldCount + 1);
            countsByIpMapByUsers.put(user, countsByIp);
            line = scanner.nextLine();
        }

        // 2. Output printing:
        countsByIpMapByUsers.forEach( (user, countByIpMap) -> {
            System.out.printf("%s:\n", user);
            int innerMapSize = countByIpMap.size();
            int counter = 0;

            for (Map.Entry<String, Integer> innerEntry : countByIpMap.entrySet()) {
                counter++;
                String ip = innerEntry.getKey();
                int counts = innerEntry.getValue();
                messagePrinting(innerMapSize, counter, ip, counts);
            }
        });
    }

    private static void messagePrinting(int innerMapSize, int counter, String ip, int counts) {
        if (counter == innerMapSize) {
            System.out.printf("%s => %d.\n", ip, counts);
        } else {
            System.out.printf("%s => %d, ", ip, counts);
        }
    }
}
