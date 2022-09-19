package T11ExamPreparation.E14August2018;

import java.util.*;
import java.util.stream.Collectors;

public class P01Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> numbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(number -> numbers.push(number));

        ArrayDeque<String> agents = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).forEach(agent -> agents.offer(agent));

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] array = input.split(" ");
            String command = array[0];
            switch (command) {
                case "add-ID":
                    String newNumber = array[1];
                    numbers.push(newNumber);
                    break;

                case "add-agent":
                    String newAgent = array[1];
                    agents.offer(newAgent);
                    break;

                case "remove-ID":
                    String numberForRemoving = numbers.pop();
                    System.out.printf("%s has been removed.%n", numberForRemoving);
                    break;

                case "remove-agent":
                    String lastAgent = null;
                    int agentCounter = 0;

                    for (String currentAgent : agents) {
                        agentCounter++;
                        if (agentCounter == agents.size()) {
                            agents.remove(currentAgent);
                            System.out.printf("%s has left the queue.%n", currentAgent);
                        }
                    }
                    break;

                case "sort-ID":
                    List<String> newList = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                    numbers.clear();
                    newList.forEach(element -> numbers.offer(element));
                    break;
            }

            input = scanner.nextLine();
        }

        while (!numbers.isEmpty() && !agents.isEmpty()) {
            System.out.printf("%s takes ID number: %s%n", agents.poll(), numbers.pop());
        }

        if (agents.isEmpty() && !numbers.isEmpty()) {
            System.out.println("No more agents left.");
            numbers.forEach(number -> System.out.printf("ID number: %s%n", number));
        } else if (!agents.isEmpty() && numbers.isEmpty()) {
            agents.forEach(agent -> System.out.printf("%s does not have an ID.%n", agent));
        }

    }
}