package T03SetsAndMapsAdvanced.Exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12SerbianMusic {
    private static String regex = "(?<singer>([A-Za-z]+ ){1,3})@(?<town>([A-Za-z]+ ){1,3})(?<price>[0-9]+) (?<number>[0-9]+)";

    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        // 2. Regex writing and regex if the input matches adding it to a map
        Pattern pattern = Pattern.compile(regex);

        //   town       singer  amount
        Map<String, Map<String, Long>> amountBySingerMapByTown = new LinkedHashMap<>();
        while (!line.equals("End")) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                String singer = matcher.group("singer");
                String town = matcher.group("town");
                int price = Integer.parseInt(matcher.group("price"));
                int number = Integer.parseInt(matcher.group("number"));
                long amount = (long) price * number;

                amountBySingerMapByTown.putIfAbsent(town, new LinkedHashMap<>());
                Map<String, Long> amountBySinger = amountBySingerMapByTown.get(town);
                amountBySinger.putIfAbsent(singer, 0L);
                long oldAmount = amountBySinger.get(singer);
                amountBySinger.put(singer, oldAmount + amount);
                amountBySingerMapByTown.put(town, amountBySinger);
            }
            line = scanner.nextLine();
        }

        // 3. Sorting and printing the output
        amountBySingerMapByTown.forEach( (town, amountBySinger) -> {
            System.out.println(town);
            amountBySinger.entrySet().stream()
                    .sorted(amountComparator())
                    .forEach(printing());
        });
    }

    private static Comparator<Map.Entry<String, Long>> amountComparator() {
        return (e1, e2) -> {
            long amount1 = e1.getValue();
            long amount2 = e2.getValue();
            return Long.compare(amount2, amount1);
        };
    }

    private static Consumer<Map.Entry<String, Long>> printing() {
        return (entry) -> {
            String singer = entry.getKey();
            long amount = entry.getValue();
            System.out.printf("#  %s-> %d\n", singer, amount);
        };
    }
}
