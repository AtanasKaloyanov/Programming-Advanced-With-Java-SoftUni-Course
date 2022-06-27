package T10Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class PMergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(element -> Integer.parseInt(element)).toArray();
        mergeSort(array);

        Arrays.stream(array).forEach(element -> System.out.println(element));

    }

    private static void mergeSort(int[] array) {
        int length = array.length;

        if (array.length < 2) {
            return;
        }

        int middleIndex = length / 2;
        int[] leftHalf = new int[middleIndex];
        int[] rightHalf = new int[length - middleIndex];

        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = array[i];
        }

        for (int i = leftHalf.length; i < array.length; i++) {
            rightHalf[i - leftHalf.length] = array[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(array, leftHalf, rightHalf);
    }

    private static void merge(int[] array, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftSize && j < rightSize) {

            if (leftHalf[i] <= rightHalf[j]) {
                array[k] = leftHalf[i];
                i++;
            } else {
                array[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            array[k] = leftHalf[i];
            k++;
            i++;
        }

        while (j < rightSize) {
            array[k] = rightHalf[j];
            k++;
            j++;
        }
    }

}
