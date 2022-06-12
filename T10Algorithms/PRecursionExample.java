package T10Algorithms;

public class PRecursionExample {
    public static void main(String[] args) {
        f(3);
    }

    public static void f(int counter) {
        if (counter == 0) {
            return;
        }

        System.out.println("Before");
        counter--;
        f(counter);
        System.out.println("After");
    }
}
