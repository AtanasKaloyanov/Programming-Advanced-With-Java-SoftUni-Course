package T08Generics.Exercise.P03GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.list.get(firstIndex);
        T secondElement = this.list.get(secondIndex);

        this.list.set(firstIndex, secondElement);
        this.list.set(secondIndex, firstElement);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : list) {
             builder.append(element.getClass().getName()).append(": ").append(element).append("\n");
        }

        return builder.toString();
    }
}
