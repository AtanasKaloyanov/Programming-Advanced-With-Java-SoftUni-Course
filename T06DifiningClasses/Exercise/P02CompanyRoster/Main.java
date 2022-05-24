package T06DifiningClasses.Exercise.P02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> map = new LinkedHashMap<>();


        for (int i = 1; i <= number; i++) {
            String[] array = scanner.nextLine().split("\\s+");

            String name = array[0];
            double salary = Double.parseDouble(array[1]);
            String position = array[2];
            String department = array[3];

            Employee employee = null;

            if (array.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (array.length == 5) {
                if (array[4].contains("@")) {
                    String email = array[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(array[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (array.length == 6) {
                String email = array[4];
                int age = Integer.parseInt(array[5]);
                employee = new Employee(name, salary, position, department, email, age);

            }

            map.putIfAbsent(department, new ArrayList<>());
            map.get(department).add(employee);
        }

        String departMentWithMaxAvarageSalary = map.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> getTheHighestSalary(entry.getValue())))
                .get()
                .getKey();

        List<Employee> list = map.get(departMentWithMaxAvarageSalary);
        list.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(list);

        System.out.printf("Highest Average Salary: %s%n", departMentWithMaxAvarageSalary);
        for (Employee employee: list) {
            System.out.println(employee.toString());
        }

    }

    private static double getTheHighestSalary(List<Employee> list) {
        double salarySum = 0;
        for (int i = 0; i < list.size(); i++) {
            for (Employee employee : list) {
                salarySum += employee.getSalary();
            }
        }

        return salarySum / list.size();
    }
}