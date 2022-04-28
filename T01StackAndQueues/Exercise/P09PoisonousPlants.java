package T01StackAndQueues.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPlants = Integer.parseInt(scanner.nextLine());
        List<Integer> pesticideArray = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        int[] days = new int[numberPlants];
        ArrayDeque<Integer> plantsNumberStack = new ArrayDeque<>();
        plantsNumberStack.push(0);

        for (int i = 1; i < pesticideArray.size(); i++) {
            int day = 0;

            while (!plantsNumberStack.isEmpty() && pesticideArray.get(plantsNumberStack.peek()) >= pesticideArray.get(i))
                day = Math.max(day, days[plantsNumberStack.pop()]);

            if (!plantsNumberStack.isEmpty()) {
                days[i] = day + 1;
            }

            plantsNumberStack.push(i);
        }

        int max = Arrays.stream(days).max().getAsInt();
        System.out.println(max);
    }
}
