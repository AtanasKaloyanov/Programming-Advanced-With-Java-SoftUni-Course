package T09IteratorsAndComparators.Exercise.P04Froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> list = new ArrayList<>();

    public List<Integer> getList() {
        return this.list;
    }

    public void addPositions(List<Integer> positions) {
        this.list.addAll(positions);
    }

    public class Frog implements Iterator<Integer> {
        private int oddIndex;
        private int evenIndex;

        public Frog() {
            this.oddIndex = 1;
        }

        public boolean hasEvenNext() {
            return this.evenIndex < getList().size();
        }

        public boolean hasOddNext() {
            return this.oddIndex < getList().size();
        }

        @Override
        public boolean hasNext() {
            return hasEvenNext() || hasOddNext();
        }

        @Override
        public Integer next() {
            Integer currentElement;
            if (hasEvenNext()) {
                currentElement = getList().get(this.evenIndex);
                this.evenIndex += 2;
            } else {
                currentElement = getList().get(this.oddIndex);
                this.oddIndex += 2;
            }

            return currentElement;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Lake.Frog();
    }
}
