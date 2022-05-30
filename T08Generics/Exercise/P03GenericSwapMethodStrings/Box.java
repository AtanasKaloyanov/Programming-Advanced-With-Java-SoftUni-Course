package T08Generics.Exercise.P03GenericSwapMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = list.get(firstIndex);
        T secondElement = list.get(secondIndex);

        list.set(firstIndex, secondElement);
        list.set(secondIndex, firstElement);
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
