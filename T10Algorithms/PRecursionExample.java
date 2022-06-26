package T10Algorithms;

public class PRecursionExample {
    public static void main(String[] args) {
        recursionExample(3);
    }

    public static void recursionExample(int counter) {

        if (counter == 0) {
            return;
        }

        System.out.println("Printing before the base case");
        counter--;
        recursionExample(counter);
        System.out.println("Printing after the base case");
    }
}
