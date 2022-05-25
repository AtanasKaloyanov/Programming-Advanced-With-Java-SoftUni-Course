package T07Workshop.Lab.P01SmartArray;

import java.util.function.Consumer;

public class SmartArray {
    public static final int INITIAL_CAPACITY = 4;
    public static final int INITIAL_SIZE = 0;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.capacity = INITIAL_CAPACITY;
        this.size = INITIAL_SIZE;
        this.data = new int[INITIAL_CAPACITY];
    }


    public int size() {
        return this.size;
    }

    private void resize() {
        this.capacity *= 2;
        int[] temp = new int[this.capacity];

        for (int i = 0; i < this.size; i++) {
            temp[i] = this.data[i];
        }

        this.data = temp;
    }


    public void add(int element) {
        this.ensureCapacity();

        this.data[size] = element;
        this.size++;
    }

    private void checkIndex(int index) {
        if (index >= this.size || index < 0) {
            String errorMessage = String.format("Index %d is out of bounds for the SmartArray!", index);
            throw new IndexOutOfBoundsException(errorMessage);
        }
    }

    public int get(int index) {
        this.checkIndex(index);
        return this.data[index];
    }

    public int remove(int index) {
        int numberToRemove = this.get(index);
        this.shiftLeft(index);
        this.size--;
        if (this.capacity / this.size > 4) {
            shrink();
        }
        return numberToRemove;

    }

    public void shrink() {
        this.capacity /= 2;
        int temp[] = new int[this.capacity];

        for (int i = 0; i < size; i++) {
            temp[i] = this.data[i];
        }

        this.data = temp;
    }

    private void shiftLeft(int index) {
        for (int i = index + 1; i < this.size; i++) {
            this.data[i - 1] = this.data[i];
        }
        this.data[size - 1] = 0;

    }

    public boolean contains(int searchedElement) {
        for (int i = 0; i < size; i++) {
            int currentElement = this.data[i];
            if (currentElement == searchedElement) {
                return true;
            }
        }
        return false;
    }

    public void addElementByIndex(int index, int element) {
        this.ensureCapacity();
        this.size++;
        this.checkIndex(index);
        this.shiftRight(index);
        this.data[index] = element;
    }

    private void shiftRight(int index) {
        for (int i = size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void ensureCapacity() {
        if (this.size == this.capacity) {
            resize();
        }
    }

    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
