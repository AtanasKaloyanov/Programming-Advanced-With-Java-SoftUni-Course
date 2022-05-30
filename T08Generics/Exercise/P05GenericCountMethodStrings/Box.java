package T08Generics.Exercise.P05GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public int countingBetterElements(T givenElement) {
        int counter = 0;
        for (T currentElement : this.list) {
            if (currentElement.compareTo(givenElement) > 0) {
                counter++;
            }
        }
        return counter;
    }
}
