package T03SetsAndMapsAdvanced.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> map = new TreeMap<>();

        for (int i = 1; i <= numberStudents; i++) {

                String name = scanner.nextLine();
                List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                        .map(e -> Double.parseDouble(e))
                        .collect(Collectors.toList());

                map.putIfAbsent(name, new ArrayList<>());

                for (int k = 0; k < grades.size(); k++) {
                    double currentGrade = grades.get(k);
                    map.get(name).add(currentGrade);
                }

        }

        map.forEach( (key, value) -> {

            double gradesSum = 0;
            for (int i = 0; i < value.size(); i++) {
                gradesSum += value.get(i);
            }

            DecimalFormat df = new DecimalFormat("0.##################");
            System.out.printf("%s is graduated with %s%n", key, df.format(gradesSum / value.size()));
        });
    }
}