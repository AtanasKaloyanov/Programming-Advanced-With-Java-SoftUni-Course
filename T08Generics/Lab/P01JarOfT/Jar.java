package T08Generics.Lab.P01JarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public ArrayDeque<T> getStack() {
        return this.stack;
    }

    public void add(T element) {
        this.stack.push(element);
    }

    public T remove() {
        return this.stack.pop();
    }

}
