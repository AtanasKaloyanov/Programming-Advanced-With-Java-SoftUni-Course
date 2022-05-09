package T03SetsAndMapsAdvanced.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Double.parseDouble(e))
                .collect(Collectors.toList());

        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            double currentDouble = numbers.get(i);

            if (!map.containsKey(currentDouble)) {
                map.put(currentDouble, 1);
            } else {
                map.put(currentDouble, map.get(currentDouble) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
