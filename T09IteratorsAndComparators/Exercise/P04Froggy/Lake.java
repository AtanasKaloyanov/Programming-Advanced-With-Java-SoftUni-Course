package T09IteratorsAndComparators.Exercise.P04Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> list;
    private int secondIndex;

    public Lake (List<Integer> list) {
        this.list = list;
        this.secondIndex = 1;
    }

    public boolean hasNext2() {
        return secondIndex < list.size();
    }

    public Integer next2() {
        int currentNumber = list.get(secondIndex);
        this.secondIndex = secondIndex + 2;
        return currentNumber;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        private int index;
        private int secondIndex;

        public Frog() {
            this.index = 0;
            this.secondIndex = 1;
        }

        @Override
        public boolean hasNext() {
            return index < list.size();
        }


        @Override
        public Integer next() {
            int currentNumber = list.get(index);
            this.index = index + 2;
            return currentNumber;
        }

    }
}
