package T01StackAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
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

            if (isComposite(counter)) {
                String leavingKid = kids.poll();
                System.out.printf("Removed %s%n", leavingKid);
            } else {
                String primeCounterKid = kids.peek();
                System.out.printf("Prime %s%n", primeCounterKid);
            }
            counter++;
        }
        String lastKid = kids.peek();
        System.out.printf("Last is %s", lastKid);
    }

    private static boolean isComposite(int number) {
        if (number == 1) {
            return true;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return true;
            }
        }
        return false;
    }
}

//Maria Peter George
//2

//Removed Peter
//Prime Maria
//Prime George
//Removed Maria
//Last is George

//George Peter Misha Sara Kendal
//10

//Removed Kendal
//Prime Peter
//Prime Misha
//Removed Sara
//Prime George
//Removed George
//Prime Misha
//Removed Peter
//Last is Misha