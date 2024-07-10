package T09IteratorsAndComparators.Exercise.P02Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> list;
    private int index;
    public ListyIterator(String... elements) {
        this.list = List.of(elements);
    }

    public List<String> getList() {
        return list;
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

    public void printAll() {
        this.forEach( (element) -> System.out.print(element + " "));
        System.out.println();
    }

    public class LIterator implements Iterator<String> {
        int iterIndex;

        @Override
        public boolean hasNext() {
            return this.iterIndex < getList().size();
        }

        @Override
        public String next() {
            String currentElement = getList().get(this.iterIndex);
            this.iterIndex++;
            return currentElement;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyIterator.LIterator();
    }
}
