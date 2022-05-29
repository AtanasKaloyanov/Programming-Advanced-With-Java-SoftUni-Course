package T08Generics.Lab.P04ListUtilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListUtils listUtils = new ListUtils();
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        System.out.println(ListUtils.getMax(list));
        System.out.println(ListUtils.getMin(list));
    }
}
