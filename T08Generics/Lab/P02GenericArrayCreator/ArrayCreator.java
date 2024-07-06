package T08Generics.Lab.P02GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {
    public static<T> T[] create(int length, T element) {
        T[] array = (T[]) Array.newInstance(element.getClass(), length);
        Arrays.fill(array, element);
        return array;
    }

    public static<T> T[] create(Class<T> clazz, int length, T element) {
        T[] array = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(array, element);
        return array;
    }
}
