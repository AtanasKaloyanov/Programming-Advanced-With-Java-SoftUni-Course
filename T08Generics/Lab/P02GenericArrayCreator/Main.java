package T08Generics.Lab.P02GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        // 1. Creating an array with the first method:
        // create(int length, E element)
        // and printing its elements:

        String[] array = ArrayCreator.create(5, "A");
        printing(array);

        // 2. New line between the arrays printing:
        System.out.println();

        // 2. Creating a second array via the second method:
        // create(Class<T> clazz, int length, T element)
        // and printing it:
        String[] array2 = ArrayCreator.create(String.class, 7, "B");
        printing(array2);
    }

    public static void printing(String[] array) {
        for (String element : array) {
            System.out.print(element + " ");
        }
    }
}
