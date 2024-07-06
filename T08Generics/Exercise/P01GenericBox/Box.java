package T08Generics.Exercise.P01GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements = new ArrayList<>();
    public void addElement(T element) {
        elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
            String classInfo = element.getClass().getName();
            sb.append(classInfo)
                    .append(": ")
                    .append(element)
                    .append("\n");
        }
        return sb.toString();
    }
}
