package T09IteratorsAndComparators.Exercise.P09LinkedListTraversal;

public class Node<T> {
    private Node<T> previousNode;
    private Node<T> nextNode;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node<T> getPreviousNode() {
        return this.previousNode;
    }

    public void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    public Node<T> getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
