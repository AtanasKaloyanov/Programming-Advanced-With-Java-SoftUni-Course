package T04StreamsFilesAndDirectories.Exercise;
import java.io.*;

public class P11SerializeCustomObject {
    private static final String PATH = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\course.ser";
    private static class Course implements Serializable {
        private String name;
        private int students;

        public Course(String name, int students) {
            this.name = name;
            this.students = students;
        }

        @Override
        public String toString() {
            return "The course \"" + this.name + "\" has " + this.students + " students.";
        }
    }

    public static void main(String[] args) {
        try {
            // serialization
            Course course = new Course("Java", 100);
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(course);

            // deserialization
            FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Course courseDes = (Course) ois.readObject();
            System.out.println(courseDes.toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
