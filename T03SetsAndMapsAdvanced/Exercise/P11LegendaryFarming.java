package T03SetsAndMapsAdvanced.Exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Consumer;


public class P11LegendaryFarming {
    public static void main(String[] args) {
        // 1. Creating 2 maps: one for the legendary items and one for the junk
        Map<String, Long> quantityByLegendaryItem = new TreeMap<>();
        quantityByLegendaryItem.put("shards", 0L);
        quantityByLegendaryItem.put("fragments", 0L);
        quantityByLegendaryItem.put("motes", 0L);

        Map<String, Long> quantityByJunk = new TreeMap<>();

        // 2. Reading and adding the input into maps
        Scanner scanner = new Scanner(System.in);
        boolean legendaryItemObtained = false;
        while (!legendaryItemObtained) {
            String[] array = scanner.nextLine().split(" ");
            for (int i = 0; i < array.length; i += 2) {
                long currentQuantity = Long.parseLong(array[i]);
                String item = array[i + 1].toLowerCase();
                long oldQuantity;
                long newQuantity;

                if (quantityByLegendaryItem.containsKey(item)) {
                    oldQuantity = quantityByLegendaryItem.get(item);
                    newQuantity = oldQuantity + currentQuantity;
                    quantityByLegendaryItem.put(item, newQuantity);

                    if (newQuantity >= 250) {
                        legendaryItemObtained = true;
                        break;
                    }
                } else {
                    quantityByJunk.putIfAbsent(item, 0L);
                    oldQuantity = quantityByJunk.get(item);
                    newQuantity = oldQuantity + currentQuantity;
                    quantityByJunk.put(item, newQuantity);
                }
            }
        }

        // 3. Output sorting and printing:
        // 3.1. First line printing - finding the winning item
        // and decreasing its quantity by 250
        long shardsQuantity = quantityByLegendaryItem.get("shards");
        long fragmentsQuantity = quantityByLegendaryItem.get("fragments");
        long motesQuantity = quantityByLegendaryItem.get("motes");

        String winningObject = "";
        if (shardsQuantity >= 250) {
            quantityByLegendaryItem.put("shards", shardsQuantity - 250);
            winningObject = "Shadowmourne";
        } else if (fragmentsQuantity >= 250) {
            winningObject = "Valanyr";
            quantityByLegendaryItem.put("fragments", fragmentsQuantity - 250);
        } else if (motesQuantity >= 250) {
            winningObject = "Dragonwrath";
            quantityByLegendaryItem.put("motes", motesQuantity - 250);
        }
        System.out.printf("%s obtained!\n", winningObject);

        // 3.2. Sorting
        quantityByLegendaryItem.entrySet().stream()
                .sorted(quantityDescSorting())
                .forEach(printing());

        quantityByJunk.entrySet()
                .forEach(printing());
    }

    private static Comparator<Map.Entry<String, Long>> quantityDescSorting() {
        return (e1, e2) -> {
            long quantity1 = e1.getValue();
            long quantity2 = e2.getValue();
            return Long.compare(quantity2, quantity1);
        };
    }

    private static Consumer<Map.Entry<String, Long>> printing() {
        return (entry) -> {
            String element = entry.getKey();
            long quantity = entry.getValue();
            System.out.printf("%s: %d\n", element, quantity);
        };
    }
}

/*
Input 1:
QuantityByLegendaryItem
shards - 0
fragments - 0
motes - 0

QuantityByJunk

1.
Motes - 3
Stones - 5
Shards - 5

QuantityByLegendaryItem
Shards - 5
fragments - 0
motes - 3

QuantityByJunk
Stones - 5

2.
leather - 6
fragments - 255
shards - 7

QuantityByLegendaryItem
Shards - 5
fragments - 255
motes - 3

QuantityByJunk
Stones - 5
Leather - 6

Some of the legendary items quantity becomes 250 or more => the program ends
sorting and printing of the legendary items and the junks
 */



