package T10Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class P01RecursiveArraySumSecondSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(element -> Integer.parseInt(element)).toArray();

        int sum = sumCalculation(array, 0);
        System.out.println(sum);
    }

    private static int sumCalculation(int[] array, int index) {
        if (index == array.length - 1) {
            return array[index];
        }

        return array[index] + sumCalculation(array, index + 1);
    }
}
