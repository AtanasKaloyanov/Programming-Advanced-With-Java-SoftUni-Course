package T04StreamsFilesAndDirectories.Lab;

import java.io.*;

public class P09SerializationAndDeserialization {
    private static String outputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\serizlization.txt";
    static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.height = height;
            this.depth = depth;
            this.width = width;
        }
    }

    public static void main(String[] args) {
        Cube cube = new Cube("green", 15.3, 12.3, 3);

        try {
            // serialization
            FileOutputStream fos = new FileOutputStream(outputPath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cube);

            // deserialization
            FileInputStream fis = new FileInputStream(outputPath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Cube c = (Cube) ois.readObject();
            printing(c);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printing(Cube c) {
        System.out.println(c.color);
        System.out.println(c.depth);
        System.out.println(c.height);
    }
}
