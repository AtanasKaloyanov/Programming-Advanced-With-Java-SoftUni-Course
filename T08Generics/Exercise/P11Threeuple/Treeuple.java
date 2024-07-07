package T08Generics.Exercise.P11Threeuple;

public class Treeuple<T, E, K> {
    private T item1;
    private E item2;
    private K item3;

    public Treeuple(T item1, E item2, K item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return this.item1 + " -> " + this.item2 + " -> " + this.item3;
    }

}
