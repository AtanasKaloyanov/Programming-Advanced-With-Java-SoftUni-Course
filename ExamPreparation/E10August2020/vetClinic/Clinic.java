package T11ExamPreparation.E10August2020.vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity) {
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
            if (datum.getName().equals(name)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet datum : data) {
            if (datum.getName().equals(name) && datum.getOwner().equals(owner)) {
                return datum;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        Pet oldestPet = null;
        int max = 0;
        for (Pet datum : data) {
            if (datum.getAge() > max) {
                max = datum.getAge();
                oldestPet = datum;
            }
        }
        return oldestPet;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append("\n");
        for (Pet datum : data) {
            sb.append(String.format("%s %s", datum.getName(), datum.getOwner())).append("\n");
        }
        return sb.toString().trim();
    }
}
