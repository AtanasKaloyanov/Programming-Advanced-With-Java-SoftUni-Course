package T04StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P02WriteFile {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        FileInputStream fileStream = new FileInputStream(path);

        try {
            int oneByte = fileStream.read();

            while (oneByte >= 0) {

                if (oneByte == 33 || oneByte == 44 || oneByte == 46 || oneByte == 63) {
                    oneByte = fileStream.read();
                    continue;
                } else {
                    System.out.print((char) oneByte);
                }

                oneByte = fileStream.read();
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
