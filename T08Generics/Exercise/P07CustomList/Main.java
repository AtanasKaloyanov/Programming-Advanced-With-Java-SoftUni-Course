package T08Generics.Exercise.P07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] array = input.split("\\s+");
            String command = array[0];

            switch (command) {
                case "Add":
                    String elementForAdding = array[1];
                    customList.add(elementForAdding);
                    break;

                case "Remove":
                    int index = Integer.parseInt(array[1]);
                    customList.remove(index);
                    break;

                case "Contains":
                    String elementForChecking = array[1];
                    System.out.println(customList.contains(elementForChecking));
                    break;

                case "Swap":
                    int firstIndex = Integer.parseInt(array[1]);
                    int secondIndex = Integer.parseInt(array[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;

                case "Greater":
                    String elementForComparing = array[1];
                    System.out.println(customList.countGreaterThan(elementForComparing));
                    break;

                case "Max":
                    System.out.println(customList.getMax());
                    break;

                case "Min":
                    System.out.println(customList.getMin());
                    break;

                case "Print":
                    System.out.print(customList);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
