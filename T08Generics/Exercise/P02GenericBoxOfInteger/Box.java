package T08Generics.Exercise.P02GenericBoxOfInteger;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        list = new ArrayList<>();
    }

    public void addElement(T element) {
        list.add(element);
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
