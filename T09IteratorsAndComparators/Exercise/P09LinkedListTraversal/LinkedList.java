package T09IteratorsAndComparators.Exercise.P09LinkedListTraversal;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Node<T> getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }

    public void addLast(T element) {
        Node<T> addingNode = new Node<>(element);

        if (isEmpty()) {
            this.head = addingNode;
            this.tail = addingNode;
        } else {
            addingNode.setPreviousNode(this.tail);
            this.tail.setNextNode(addingNode);
            this.tail = addingNode;
        }
        this.size++;
    }

    public void removeFirst(T element) {
        // exception by empty structure
        if (this.isEmpty()) {
            throw new NullPointerException();
        }

        Node<T> current = this.head;
        while (current != null) {
            T currentValue = current.getValue();
            if (currentValue.equals(element)) {
                Node<T> previous = current.getPreviousNode();
                Node<T> next = current.getNextNode();
                // removing the head
                if (previous == null) {
                    Node<T> newHead = this.head.getNextNode();
                    newHead.setPreviousNode(null);
                    this.head = newHead;
                    // removing the tail
                } else if (next == null) {
                    Node<T> newTail = this.tail.getPreviousNode();
                    newTail.setNextNode(null);
                    this.tail = newTail;
                    // removing an element in the middle
                } else {
                    previous.setNextNode(next);
                    next.setPreviousNode(previous);
                }
                this.size--;
                break;
            }
            current = current.getNextNode();
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public class IteratorAssisistant implements Iterator<T> {
        private Node<T> currentElement = getHead();

        @Override
        public boolean hasNext() {
            return this.currentElement != null;
        }

        @Override
        public T next() {
            Node<T> previous = this.currentElement;
            this.currentElement = this.currentElement.getNextNode();
            return previous.getValue();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorAssisistant();
    }
}

// If isEmpty:

// head                  tail

// prev = null           prev = null
// next = null           next = null
// T element = 1         T element = 1;

// Else:

// head                  tail

// prev = null           prev = null
// next = null           next = null
// T element = 1         T element = 1;


