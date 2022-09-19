package T11ExamPreparation.E02February2022.parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() < capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot datum : data) {
            String currentName = datum.getName();
            if (currentName.equals(name)) {
                data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot datum : data) {
            String currentName = datum.getName();
            if (currentName.equals(name)) {
                datum.setAvailable(false);
                return datum;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> newList = new ArrayList<>();
        for (Parrot datum : data) {
            String current  = datum.getSpecies();
            if (current.equals(species)) {
                datum.setAvailable(false);
                newList.add(datum);
            }
        }
        return newList;
    }

    public int count () {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Parrots available at %s:%n", name));
        for (Parrot datum : data) {
            if (datum.isAvailable()) {
                  sb.append(datum);
                  sb.append("\n");
            }
        }
        return sb.toString().trim();
    }

}
