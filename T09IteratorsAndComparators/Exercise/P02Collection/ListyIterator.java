package T09IteratorsAndComparators.Exercise.P02Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> list;
    private int index;

    public ListyIterator(List<String> givenList) {
        this.list = givenList;
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

    @Override
    public Iterator<String> iterator() {
        return new Assistant();
    }

    private class Assistant implements Iterator<String> {
        private int index;

        public Assistant() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public String next() {
            String currentElement = list.get(index);
            this.index++;
            return currentElement;
        }
    }
}
