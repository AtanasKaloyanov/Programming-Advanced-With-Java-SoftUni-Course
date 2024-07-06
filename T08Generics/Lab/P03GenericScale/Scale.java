package T08Generics.Lab.P03GenericScale;

public class Scale <T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        int comparator = this.left.compareTo(this.right);
        if (comparator > 0) {
            return left;
        } else if (comparator == 0) {
            return null;
        }
        return right;
    }
}
