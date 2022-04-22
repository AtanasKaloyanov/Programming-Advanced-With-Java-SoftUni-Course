package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> kids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(kid -> kids.offer(kid));
        int passes = Integer.parseInt(scanner.nextLine());
        int counter = 1;


        while (kids.size() > 1) {
            for (int i = 1; i < passes; i++) {
                String potatoHolder = kids.peek();
                kids.offer(potatoHolder);
                kids.poll();
            }
            if (counter == 1) {
                String removedKid = kids.poll();
                System.out.printf("Removed %s%n", removedKid);
            } else {

                boolean isComposite = false;

                for (int i = 1; i <= counter; i++) {
                    if (counter % i == 0 && i != 1 && i != counter) {
                        String removedKid = kids.poll();
                        System.out.printf("Removed %s%n", removedKid);
                        isComposite = true;
                        break;
                    }
                }

                if (!isComposite) {
                    System.out.printf("Prime %s%n", kids.peek());
                }
            }

            counter++;

        }

        System.out.printf("Last is %s", kids.peek());
    }
}
// 1 - yes
//  2 - 1, 2 - no
//  3 - 1, 3 - no
//  4 - 1,2,4 - yes
//  5 - 1,5  - не
//  6 - 1,2,3,6 - yes