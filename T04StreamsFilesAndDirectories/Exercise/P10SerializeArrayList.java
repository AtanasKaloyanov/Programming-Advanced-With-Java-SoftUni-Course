package T04StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P10SerializeArrayList {
    private static final String PATH = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\list.ser";

    public static void main(String[] args) {
        try {
            // serialization
            List<Double> numbers = new ArrayList<>(List.of(1.2, 1.3, 3.14));
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(numbers);

            // deserialization
            FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Double> list = (List<Double>) ois.readObject();
            System.out.println(list);

            // stream closing
            oos.close();
            ois.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
