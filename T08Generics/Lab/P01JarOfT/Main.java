package T08Generics.Lab.P01JarOfT;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        // 1. Adding the jar with 3 coins (objects of type Integer) and printing them:
        Jar<Integer> coinsJar = new Jar<>();
        coinsJar.add(1);
        coinsJar.add(1);
        coinsJar.add(2);
        ArrayDeque<Integer> coinsStack = coinsJar.getStack();
        System.out.println(coinsStack);

        // 1.1. removing and printing again
        System.out.println(coinsJar.remove());
        System.out.println(coinsStack);

        // 2. New line printing
        System.out.println();

        // 2. Adding the jar with 2 objects of type Pickle and printing them:
        Jar<Pickle> pickleJar = new Jar<>();
        Pickle pickle1 = new Pickle();
        Pickle pickle2 = new Pickle();
        pickleJar.add(pickle1);
        pickleJar.add(pickle2);
        ArrayDeque<Pickle> picleStack = pickleJar.getStack();
        System.out.println(picleStack);

        // 2.1. removing and printing again
        System.out.println(pickleJar.remove());
        System.out.println(picleStack);
    }
}
