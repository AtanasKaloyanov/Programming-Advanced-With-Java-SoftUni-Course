package T06DifiningClasses.Exercise.P02CompanyRoster;

public class Employee implements Comparable<Employee> {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee employee2) {
        return Double.compare(employee2.salary, this.salary);
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }
}
