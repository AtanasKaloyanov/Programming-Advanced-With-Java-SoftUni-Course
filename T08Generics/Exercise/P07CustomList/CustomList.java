package T08Generics.Exercise.P07CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        T elementForRemoving = this.list.get(index);
        this.list.remove(elementForRemoving);
        return elementForRemoving;
    }

    public boolean contains(T element) {
        if (this.list.contains(element)) {
            return true;
        }
        return false;
    }

    public void swap(int firsIndex, int secondIndex) {
        T firstElement = this.list.get(firsIndex);
        T secondElement = this.list.get(secondIndex);

        this.list.set(firsIndex, secondElement);
        this.list.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T element) {
        int counter = 0;
        for (T currentElement : this.list) {
            if (currentElement.compareTo(element) > 0) {
                counter++;
            }
        }
        return counter;
    }

    public T getMax() {
        T bestElement = this.list.get(0);
        for (T currentElement : this.list) {
            if (currentElement.compareTo(bestElement) > 0) {
                bestElement = currentElement;
            }
        }
        return bestElement;
    }

    public T getMin() {
        T worstElement = this.list.get(0);
        for (T currentElement : this.list) {
            if (currentElement.compareTo(worstElement) < 0) {
                worstElement = currentElement;
            }
        }
        return worstElement;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T elemement : this.list) {
            builder.append(elemement).append("\n");
        }
        return builder.toString();
    }
}
