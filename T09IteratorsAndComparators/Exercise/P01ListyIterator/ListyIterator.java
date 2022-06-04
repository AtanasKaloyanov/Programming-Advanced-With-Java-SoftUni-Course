package T09IteratorsAndComparators.Exercise.P01ListyIterator;

import java.util.List;

public class ListyIterator {
    private List<String> list;
    private int index;

    public ListyIterator(List<String> collection) {
         this. list = collection;
         this.index = 0;
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < list.size() - 1;
    }

    public void print() {
        if (list.isEmpty()) {
            System.out.println("Invalid Operation!");
        } else {
            System.out.println(this.list.get(index));
        }
    }
}
