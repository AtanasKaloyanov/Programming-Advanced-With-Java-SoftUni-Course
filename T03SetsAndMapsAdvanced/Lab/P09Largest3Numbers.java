package T03SetsAndMapsAdvanced.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .sorted(
                        (left, right) -> right.compareTo(left)
                )
                . collect(Collectors.toList());

        for (int i = 0; i < 3; i++) {
          if (i == numbers.size()) {
              break;
          }
            System.out.print(numbers.get(i) + " ");
        }

    }
}
