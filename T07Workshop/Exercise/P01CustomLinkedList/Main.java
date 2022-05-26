package T07Workshop.Exercise.P01CustomLinkedList;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);

        int[] array = linkedList.toArray();

        for (int currentElement : array) {
            System.out.println(currentElement);
        }

    }
}
