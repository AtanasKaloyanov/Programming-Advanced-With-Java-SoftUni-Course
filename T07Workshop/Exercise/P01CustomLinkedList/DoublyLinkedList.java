package T07Workshop.Exercise.P01CustomLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.nextElement = head;
            this.head.previousElement = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.previousElement = tail;
            this.tail.nextElement = newNode;
            this.tail = newNode;
        }
        size++;
    }

    public int get(int index) {
        checkValidIndex(index);

        int result = 0;
        if (index <= this.size / 2) {
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.nextElement;
            }
            result = currentNode.currentValue;
        } else {
            Node currentNode = this.tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previousElement;
            }
            result = currentNode.currentValue;
        }

        return result;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty!");
        } else if (this.size == 1) {
            int removedElement = this.head.currentValue;
            this.head = this.tail = null;
            this.size--;
            return removedElement;
        } else {
            int removedElement = this.head.currentValue;
            this.head = this.head.nextElement;
            this.head.previousElement = null;
            this.size--;
            return removedElement;
        }
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty!");
        } else if (this.size == 1) {
            int removedElement = this.tail.currentValue;
            this.head = this.tail = null;
            this.size--;
            return removedElement;
        } else {
            int removedElement = this.tail.currentValue;
            this.tail = this.tail.previousElement;
            this.tail.nextElement = null;
            this.size--;
            return removedElement;
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;

        while (currentNode != null) {
           consumer.accept(currentNode.currentValue);
           currentNode = currentNode.nextElement;
        }
    }

    public int[] toArray() {
        List<Integer> list = new ArrayList<>();
        forEach(e -> list.add(e));

        return list.stream().mapToInt(e -> e).toArray();
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("The index is out of bounds!");
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
