package T08Generics.Lab.P02GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
          public static <T> T[] create(int length, T item) {
              T[] array = (T[]) new Object[length];

              for (int i = 0; i < length; i++) {
                  array[i] = item;
              }

              return array;
    }

        public static <T> T[] create(Class<T> clazz, int length, T item) {
            T[] array = (T[]) Array.newInstance(clazz, 5);

            for (int i = 0; i < array.length; i++) {
                array[i] = item;
            }

            return array;
        }
}
