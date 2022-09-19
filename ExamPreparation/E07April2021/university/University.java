package T11ExamPreparation.E07April2021.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public List<Student> students;
    public int capacity;

    public University(int capacity) {
        this.students = new ArrayList<>();
        this.capacity = capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        StringBuilder sb = new StringBuilder();

        if (capacity > students.size() && !students.contains(student)) {
            students.add(student);
            sb.append(String.format("Added student %s %s", student.getFirstName(), student.getLastName()));
        } else if (students.contains(student)) {
            sb.append("Student is already in the T11ExamPreparation.E07April2021.university");
        } else if (capacity <= students.size()) {
            sb.append("No seats in the T11ExamPreparation.E07April2021.university");
        }

        return sb.toString().trim();
    }

    public String dismissStudent(Student student) {
        String result;
        if (!students.contains(student)) {
            result = "Student not found";
        } else {
            students.remove(student);
            result = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }
        return result;
    }

   public Student getStudent(String firstName, String lastName) {
        for (Student currentStudent : students) {
            if (currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)) {
                return currentStudent;
            }
        }
        return null;
    }

   public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student currentStudent : students) {
            sb.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n", currentStudent.getFirstName(), currentStudent.getLastName(), currentStudent.getBestSubject()));
        }
        return sb.toString().trim();
    }

}

