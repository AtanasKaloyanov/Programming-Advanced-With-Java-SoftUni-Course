package T08Generics.Exercise.P07CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
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
        return Collections.max(this.list);
    }

    public T getMin() {
        return Collections.min(this.list);
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
