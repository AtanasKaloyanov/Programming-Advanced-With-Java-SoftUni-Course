package T03SetsAndMapsAdvanced.Exercise;
import java.util.*;

public class P06AMinerTask {
    public static void main(String[] args) {
        // 1. Input reading and adding the into a map
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, Integer> quantityByElement = new LinkedHashMap<>();
        while (!line.equals("stop")) {
            int addedQuantity = Integer.parseInt(scanner.nextLine());
            quantityByElement.putIfAbsent(line, 0);
            int currentQuantity = quantityByElement.get(line);
            quantityByElement.put(line, currentQuantity + addedQuantity);
            line = scanner.nextLine();
        }

        // 2. Output printing:
        quantityByElement.forEach( (key, value) ->
                System.out.printf("%s -> %d\n", key, value));
    }
}
