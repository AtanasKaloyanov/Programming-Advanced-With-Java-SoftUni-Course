package T04StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Demo {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        FileInputStream fileStream = new FileInputStream(path);

        try {
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte = fileStream.read();
            }
        } catch (IOException a) {
            a.printStackTrace();
        }


    }
}
