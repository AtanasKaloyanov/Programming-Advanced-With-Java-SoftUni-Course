package T08Generics.Exercise.P04GenericSwapMethodsIntegers;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements = new ArrayList<>();
    public void addElement(T element) {
        elements.add(element);
    }

    public void swap(int index1, int index2) {
        T element1 = this.elements.get(index1);
        T element2 = this.elements.get(index2);
        this.elements.set(index1, element2);
        this.elements.set(index2, element1);
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
