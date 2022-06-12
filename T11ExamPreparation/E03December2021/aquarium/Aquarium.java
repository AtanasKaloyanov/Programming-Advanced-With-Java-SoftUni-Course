package T11ExamPreparation.E03December2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {
        if (fishInPool.size() < capacity) {
            boolean isInThePool = false;
            for (Fish currentFish : fishInPool) {
                if (currentFish.getName().equals(fish.getName())) {
                    isInThePool = true;
                    break;
                }
            }
            if (!isInThePool) {
                fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        for (Fish currentFish : fishInPool) {
            String currentName = currentFish.getName();
            if (name.equals(currentName)) {
                fishInPool.remove(currentFish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        for (Fish currentFish : fishInPool) {
            String currentName = currentFish.getName();
            if (name.equals(currentName)) {
                return currentFish;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d", name, size)).append("\n");
        for (Fish currentFish : fishInPool) {
            sb.append(currentFish);
            sb.append("\n");
        }
        return sb.toString().trim();
    }

}
