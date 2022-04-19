package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int passes = Integer.parseInt(scanner.nextLine());
        String[] array = input.split(" ");
        ArrayDeque<String> kids = new ArrayDeque<>();
        Collections.addAll(kids, array);

        while (kids.size() > 1) {
            for (int i = 1; i < passes; i++) {
                String potatoHolder = kids.peek();
                kids.offer(potatoHolder);
                kids.poll();
            }
            String leavingKid = kids.peek();
            kids.poll();
            System.out.printf("Removed %s%n", leavingKid);
        }
        String lastKid = kids.peek();
        System.out.printf("Last is %s", lastKid);
    }
}

// 1    2
//Sam John Sarah   -->  John

// 2    1
//Sam Sarah    --> Sam

//Sarah     -->   Sarah