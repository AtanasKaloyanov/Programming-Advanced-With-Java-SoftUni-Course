package T09IteratorsAndComparators.Lab.PShopAndShopassistant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Supermarket implements Iterable<String> {
    private List<String> fruits;

    public Supermarket(String firstFruit, String secondFruit, String thirdFruit) {
        this.fruits = new ArrayList<>(Arrays.asList(firstFruit,secondFruit,thirdFruit));
    }


    @Override
    public Iterator<String> iterator() {
       return new ShopAssistant();
    }

    private class ShopAssistant implements Iterator<String>{

        int index = 0;
        @Override
        public boolean hasNext() {
            return index < fruits.size();
        }

        @Override
        public String next() {
            return fruits.get(index++);
        }
    }
}
