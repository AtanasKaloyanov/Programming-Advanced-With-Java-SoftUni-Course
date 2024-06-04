package T01StackAndQueues.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PoisonousPlantsSecondSolution {
    public static void main(String[] args) {
            // 1. Input reading
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            List<Integer> numbers = readNumbers(scanner);

            // 2. Creating a tempList and adding every element that is smaller or equals to its left element to it.
            // If this tempList is equals to the numbers breaking. In other case continuing the algorithm.
            int days = 0;
            while (true) {
                List<Integer> tempList = new ArrayList<>();
                int firstNumber = numbers.get(0);
                tempList.add(firstNumber);
                for (int i = 1; i < numbers.size(); i++) {
                    int currentNumber = numbers.get(i);
                    int previousNumber = numbers.get(i - 1);
                    if (currentNumber <= previousNumber) {
                        tempList.add(currentNumber);
                    }
                }
                if (tempList.equals(numbers)) {
                    break;
                }
                numbers = tempList;
                days++;
            }

            // 3. Output printing:
            System.out.println(days);
        }

        private static List<Integer> readNumbers(Scanner scanner) {
            return Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    }

/*
Input 1:
6 5 8 4 7 10 9

day 1: 6 5 4 9
day 2: 6 5 4

Output 1: 2

Input 2:
7 2 3 9 2

day 1: 7 2 2

Output 2: 1

 */
    

