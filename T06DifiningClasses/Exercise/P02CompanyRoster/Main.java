package T06DifiningClasses.Exercise.P02CompanyRoster;

import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // 1. Input reading:
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        // 2. For cycle algorithm. Reading fields and creating and Employee, then adding it
        // to a Map:

        Map<String, TreeSet<Employee>> employeesByDepartmentMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            // 2.1. Reading the mandatory fields:
            String[] array = scanner.nextLine().split(" ");
            String name = array[0];
            double salary = Double.parseDouble(array[1]);
            String position = array[2];
            String department = array[3];
            Employee employee = new Employee(name, salary, position, department);

            // 2.2. Setting the email and the age - 3 case:
            String email = "n/a";
            int age = -1;
            if (array.length == 6) {
                email = array[4];
                age = Integer.parseInt(array[5]);
            } else if (array.length == 5) {
                String emailOrAge = array[4];
                if (isNumber(emailOrAge)) {
                    age = Integer.parseInt(emailOrAge);
                } else {
                    email = emailOrAge;
                }
            }

            employee.setEmail(email);
            employee.setAge(age);

            // 2.3. Adding the employee into the map:
            employeesByDepartmentMap.putIfAbsent(department, new TreeSet<>());
            TreeSet<Employee> employees = employeesByDepartmentMap.get(department);
            employees.add(employee);
            employeesByDepartmentMap.put(department, employees);
        }

        // 3. Printing:
        employeesByDepartmentMap.entrySet().stream()
                .sorted(departmentsAvgSalaryComparator())
                .limit(1)
                .forEach(bestDepartmentPrinter());
    }

    private static Consumer<Map.Entry<String, TreeSet<Employee>>> bestDepartmentPrinter() {
        return bestEntry -> {
            String department = bestEntry.getKey();
            TreeSet<Employee> employees = bestEntry.getValue();
            System.out.printf("Highest Average Salary: %s\n", department);
            employees.forEach((System.out::println));
        };
    }

    private static Comparator<Map.Entry<String, TreeSet<Employee>>> departmentsAvgSalaryComparator() {
        return (entry1, entry2) -> {
            double department1SalaryAvg = getAvgSalary(entry1);
            double department1SalaryAvg2 = getAvgSalary(entry2);
            return Double.compare(department1SalaryAvg2, department1SalaryAvg);
        };
    }

    private static double getAvgSalary(Map.Entry<String, TreeSet<Employee>> entry1) {
        return entry1.getValue().stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .getAsDouble();
    }

    private static boolean isNumber(String emailOrAge) {
        try {
            int number = Integer.parseInt(emailOrAge);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}