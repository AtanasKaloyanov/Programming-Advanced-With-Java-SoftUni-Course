package T04StreamsFilesAndDirectories.Lab;

import java.io.*;

class Cat implements Serializable {
    String name;
    int weigth;
    int age;

    public Cat(String name, int weigth, int age) {
        this.name = name;
        this.weigth = weigth;
        this.age = age;
    }
}

public class PSerializable {
    public static void main(String[] args) {

        Cat shosho = new Cat("Shosho", 3, 3);
        String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

            oos.writeObject(shosho);
            oos.close();

            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);

            Cat zion = (Cat) ois.readObject();

            System.out.println(zion.name);
            System.out.println(zion.weigth);
            System.out.println(zion.age);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
