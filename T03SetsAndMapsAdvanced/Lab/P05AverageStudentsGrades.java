package T03SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 1; i <= number; i++) {
            String[] array = scanner.nextLine().split(" ");
            String name = array[0];
            double grade = Double.parseDouble(array[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }
        }

        students.entrySet().stream().sorted(
                        (left, rigth) -> left.getKey().compareTo(rigth.getKey())
                )
                .forEach(entry -> {
                    System.out.printf("%s -> ", entry.getKey());
                    entry.getValue().forEach(grade -> System.out.printf("%.2f ", grade));

                    double gradesSum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        double currentGrade = entry.getValue().get(i);
                        gradesSum += currentGrade;
                    }
                    System.out.printf("(avg: %.2f)%n", gradesSum / entry.getValue().size());
                });


        // Ivan  -> 2.00 3.00 4.00 -> avrg 3.00
        // Maria -> 3.00 4.00 5.00 -> avrg 4.00
    }

}