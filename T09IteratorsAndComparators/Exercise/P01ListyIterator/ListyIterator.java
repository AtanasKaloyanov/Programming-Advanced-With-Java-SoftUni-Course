package T09IteratorsAndComparators.Exercise.P01ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> list;
    private int index;
    public ListyIterator(String... elements) {
        this.list = List.of(elements);
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    public void print() {
        if (this.list.isEmpty()) {
            System.out.println("Invalid Operation!");
            return;
        }

        String currentElement = this.list.get(this.index);
        System.out.println(currentElement);
    }
}
