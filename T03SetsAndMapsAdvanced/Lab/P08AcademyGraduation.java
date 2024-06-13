package T03SetsAndMapsAdvanced.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        // 1. Input reading
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> avgScoreByPerson = new TreeMap<>();

        // 2. Putting a name as a key into a map and as a value average grade .
        // The average grade should be calculated
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double avgGrade = getAvgGrade(scanner);
            avgScoreByPerson.put(name, avgGrade);
        }

        // 3. Result printing
        avgScoreByPerson.entrySet().stream()
                .forEach( (entry) -> {
                    String name = entry.getKey();
                    double avgGrade = entry.getValue();
                    DecimalFormat df = new DecimalFormat("0.#####################");
                    String avgGradeString = df.format(avgGrade);
                    System.out.printf("%s is graduated with %s\n", name, avgGradeString);
                });
    }

    private static double getAvgGrade(Scanner scanner) {
        List<Double> grades = readGrades(scanner);
        double gradesSum = 0;
        for (Double grade : grades) {
            gradesSum += grade;
        }

        return gradesSum / grades.size();
    }

    private static List<Double> readGrades(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}