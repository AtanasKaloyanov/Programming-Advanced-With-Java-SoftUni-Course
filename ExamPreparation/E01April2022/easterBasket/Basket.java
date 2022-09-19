package T11ExamPreparation.E01April2022.P03Basket.easterBaske;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    public String getMaterial() {
        return material;
    }

    public void addEgg(Egg egg) {
        if (data.size() < capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String colour) {
        for (Egg datum : data) {
            if (datum.getColor().equals(colour)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg() {
        int maxStrength = Integer.MIN_VALUE;
        Egg searchedEgg = null;
        for (Egg datum : data) {
            int currentStrength = datum.getStrength();
            if (currentStrength > maxStrength) {
                maxStrength = currentStrength;
                searchedEgg = datum;
            }
        }
        return searchedEgg;
    }

    public Egg getEgg(String color) {
        Egg searchedEgg = null;
        for (Egg datum : data) {
            String currentColour = datum.getColor();
            if (currentColour.equals(color)) {
                searchedEgg = datum;
            }
        }
        return searchedEgg;
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s basket contains:", material));
        sb.append("\n");
        for (Egg datum : data) {
            sb.append(String.format("%s", datum.toString()));
            sb.append("\n");
        }
        return sb.toString().trim();
    }

}
