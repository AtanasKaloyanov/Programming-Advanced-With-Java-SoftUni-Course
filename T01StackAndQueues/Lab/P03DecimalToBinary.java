package T01StackAndQueues.Lab;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int givenNumber = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (givenNumber != 0) {
            int remainder = givenNumber % 2;
            stack.push(remainder);
            givenNumber = givenNumber / 2;
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(stack.toString().replaceAll("[\\[\\], ]", ""));
        }
    }
}
