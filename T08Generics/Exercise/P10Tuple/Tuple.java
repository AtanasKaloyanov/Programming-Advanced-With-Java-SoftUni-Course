package T08Generics.Exercise.P10Tuple;

public class Tuple<T, E> {
    private T item1;
    private E item2;

    public Tuple(T first, E second) {
        this.item1 = first;
        this.item2 = second;
    }

    @Override
    public String toString() {
        return this.item1 + " -> " + this.item2;
    }
}
