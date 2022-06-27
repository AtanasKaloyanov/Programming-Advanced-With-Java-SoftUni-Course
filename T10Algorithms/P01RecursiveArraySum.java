package T10Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class P01RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(element -> Integer.parseInt(element)).toArray();
        System.out.println(sumCalculation(array));
    }

    public static int sumCalculation(int[] array) {
        int[] oldArray = array;
        int[] newArray = new int[array.length - 1];

        if (newArray.length == 0) {
            return oldArray[0];
        }

        for (int i = 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }

        array = newArray;

        return oldArray[0] + sumCalculation(newArray);
    }
}
