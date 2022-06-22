package T11ExamPreparation.E13December2019.christmas;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;
    private List<Present> data;
    private int capacity;

    public Bag(String color, int capacity) {
        this.color = color;
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (capacity > data.size()) {
            data.add(present);
        }
    }

    public boolean remove(String name) {
        for (Present datum : data) {
            if (datum.getName().equals(name)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent() {
        double max = 0;
        Present heaviest = null;

        for (Present datum : data) {
            if (datum.getWeight() > max) {
                max = datum.getWeight();
                heaviest = datum;
            }
        }
        return heaviest;
    }

    public Present getPresent(String name) {
        for (Present datum : data) {
            if (datum.getName().equals(name)) {
                return datum;
            }
        }
        return null;
    }


    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:", color)).append("\n");
        for (Present datum : data) {
            sb.append(datum).append("\n");
        }
        return sb.toString();
    }
}




