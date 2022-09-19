package T11ExamPreparation.E06June2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet datum : data) {
            String currentName = datum.getName();
            if (currentName.equals(name)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet datum : data) {
            String currentName = datum.getName();
            String currentOwner = datum.getOwner();
            if (currentName.equals(name) && currentOwner.equals(owner)) {
                return datum;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append("\n");
        for (Pet datum : data) {
            sb.append(String.format("%s %s", datum.getName(), datum.getOwner())).append("\n");
        }
        return sb.toString().trim();
    }
}
