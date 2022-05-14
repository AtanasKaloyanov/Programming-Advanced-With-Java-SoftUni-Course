package T04StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) {

        String inputPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        String outputPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt";

        try {
            FileInputStream in = new FileInputStream(inputPath);
            FileOutputStream out = new FileOutputStream(outputPath);

            int oneByte = in.read();

            while (oneByte >= 0) {
                if (oneByte == 32 || oneByte == 10) {
                    out.write(oneByte);
                } else {
                    String oneByteToString = String.valueOf(oneByte);
                    for (int i = 0; i < oneByteToString.length(); i++) {
                        out.write(oneByteToString.charAt(i));
                    }
                }
                oneByte = in.read();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
