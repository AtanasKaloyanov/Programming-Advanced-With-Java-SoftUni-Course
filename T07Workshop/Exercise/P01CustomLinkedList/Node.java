package T07Workshop.Exercise.P01CustomLinkedList;

public class Node {
    public int currentValue;
    public Node nextElement;
    public Node previousElement;

    public Node (int currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public String toString() {
        return String.format("%d", currentValue);
    }
}
