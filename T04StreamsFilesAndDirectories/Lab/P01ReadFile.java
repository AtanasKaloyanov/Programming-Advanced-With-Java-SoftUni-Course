package T04StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class P01ReadFile {
    public static void main(String[] args) {
        // 1. Path variable assignment
        String path = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\input.txt";

        // 2. Reading the input as byte by byte and printing every byte
        try {
            FileInputStream fileStream = new FileInputStream(path);
            // int from the ASCII Table
            int oneByte = fileStream.read();
            while (oneByte != -1) {
                // binary representation
                String binaryRepresentation = Integer.toBinaryString(oneByte);
                System.out.print(binaryRepresentation + " ");
                oneByte = fileStream.read();
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        }

    }
}
