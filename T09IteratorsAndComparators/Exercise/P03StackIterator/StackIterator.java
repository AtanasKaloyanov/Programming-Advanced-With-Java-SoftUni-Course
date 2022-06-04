package T09IteratorsAndComparators.Exercise.P03StackIterator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StackIterator implements Iterable<Integer>{
    private ArrayDeque<Integer> stack;

    StackIterator() {
         this.stack = new ArrayDeque<>();
    }

    public ArrayDeque<Integer> getStack() {
        return stack;
    }

    public void push(String numbers) {
        List<String> list = Arrays.stream(numbers.split(", | ")).collect(Collectors.toList());
        for (int i = 1; i < list.size(); i++) {
            int currentElement = Integer.parseInt(list.get(i));
            this.stack.push(currentElement);
        }
    }

    public void pop() {
            this.stack.pop();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Assistant();
    }

    private class Assistant implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return stack.size() != 0;
        }

        @Override
        public Integer next() {
            int currentElement = stack.pop();
            return  currentElement;
        }
    }
}
