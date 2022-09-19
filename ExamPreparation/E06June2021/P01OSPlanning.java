package T11ExamPreparation.E06June2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> tasks = Arrays.stream(scanner.nextLine().split(", ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        List<Integer> threads = Arrays.stream(scanner.nextLine().split(" ")).map(element -> Integer.parseInt(element)).collect(Collectors.toList());
        int taskToKill = Integer.parseInt(scanner.nextLine());

        Collections.reverse(tasks);
        int firstTask = 0;
        int firstThread = 0;


        while(true) {
            firstTask = tasks.get(0);
            firstThread = threads.get(0);

            if (firstTask == taskToKill) {
                break;
            }

            if (firstThread >= firstTask) {
                tasks.remove(0);
                threads.remove(0);
            } else {
                threads.remove(0);
            }

        }

        System.out.printf("Thread with value %d killed task %d%n", firstThread, taskToKill);
        System.out.println(String.join(" ", threads.toString().replaceAll("[\\[\\],]", "")));

    }
}
