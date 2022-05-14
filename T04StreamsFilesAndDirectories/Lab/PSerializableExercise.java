package T04StreamsFilesAndDirectories.Lab;

import java.io.*;

public class PExercise {
    public static void main(String[] args) {

        String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        Dog dog = new Dog("Rolo", 1, 5);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(dog);

            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Dog Russel = (Dog) objectInputStream.readObject();


            System.out.println(Russel.age);
            System.out.println(Russel.kilos);
            System.out.println(Russel.name);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

   class Dog implements Serializable {
    String name;
    int age;
    int kilos;

       public Dog(String name, int age, int kilos) {
           this.name = name;
           this.age = age;
           this.kilos = kilos;
       }
   }