package T03SetsAndMapsAdvanced.Lab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. Adding the grades into a map:
        Map<String, List<Double>> gradesByStudentMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] array = scanner.nextLine().split(" ");
            String name = array[0];
            double grade = Double.parseDouble(array[1]);
            gradesByStudentMap.putIfAbsent(name, new ArrayList<>());
            gradesByStudentMap.get(name).add(grade);
        }

        // 3. Result appending and printing:
        StringBuilder result = new StringBuilder();

        gradesByStudentMap.entrySet().forEach((entry) -> {
            String name = entry.getKey();
            List<Double> grades = entry.getValue();

            // 3.1. Appending name
            result.append(name).append(" -> ");

            // 3.2. Appending grades
            for (Double grade : grades) {
                String formattedGrade = String.format("%.2f ", grade);
                result.append(formattedGrade);
            }

            // 3.3. Appending avg sum
            double gradesSum = 0;
            for (Double grade : grades) {
                gradesSum += grade;
            }
            double gradesAvg = gradesSum / grades.size();
            result.append(String.format("(avg: %.2f)\n", gradesAvg));
        });

        // 3.4. Printing
        System.out.println(result);
    }
}