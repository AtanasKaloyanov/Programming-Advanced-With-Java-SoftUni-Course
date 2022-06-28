package T05FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

         List<String> list = new ArrayList<>(Arrays.asList("firstCat", "secondCat"));
        System.out.println(String.join(",", list));
    }

}
