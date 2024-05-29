package T01StackAndQueues.Lab;
import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        // 2.  0 case - printing and return:
        if (number == 0) {
            System.out.println(0);
            return;
        }

        // 3. Binary number representation algorithm via ArrayDeque
        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();

        while (number != 0) {
            int currentReminder = number % 2;
            binaryRepresentation.push(currentReminder);
            number /= 2;
        }

        // 4. The binary number representation printing
        System.out.println(binaryRepresentation.toString().replaceAll("[\\[\\], ]", ""));
    }
}
