package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;

public class P10LoggsAgregator {
    public static void main(String[] args) {
        // 1. Input reading and adding it into a map
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        //   user       Ip      duration
        Map<String, Map<String, Integer>> durationByIpMapByUser = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String ip = array[0];
            String user = array[1];
            int newDuration = Integer.parseInt(array[2]);

            durationByIpMapByUser.putIfAbsent(user, new TreeMap<>());
            Map<String, Integer> durationByIpMap =  durationByIpMapByUser.get(user);
            durationByIpMap.putIfAbsent(ip, 0);
            int oldDuration = durationByIpMap.get(ip);
            durationByIpMap.put(ip, oldDuration + newDuration);

            durationByIpMapByUser.put(user, durationByIpMap);
        }

        // 2. Output printing:
        durationByIpMapByUser.forEach( (user, durationByIpMap) -> {
            int durationSum = getDurationSum(durationByIpMap);
            String ips = durationByIpMap.keySet().toString();
            System.out.printf("%s: %d %s\n", user, durationSum, ips);
        });
    }

    private static int getDurationSum(Map<String, Integer> durationByIpMap) {
        return durationByIpMap.values().stream().mapToInt(e -> e).sum();
    }
}
