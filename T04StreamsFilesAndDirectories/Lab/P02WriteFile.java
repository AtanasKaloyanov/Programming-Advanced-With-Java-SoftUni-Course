package T04StreamsFilesAndDirectories.Lab;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P02WriteFile {
    public static void main(String[] args) {

        String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        String secondPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt";

        Set<Character> symbolsForDeleting = new HashSet<>();
        Collections.addAll(symbolsForDeleting, '?', '!', ',', '.');

        try {
            FileInputStream in = new FileInputStream(path);
            FileOutputStream out = new FileOutputStream(secondPath);

            int oneByte = in.read();
            while (oneByte >= 0) {
                char currentChar = (char) oneByte;
                if (!symbolsForDeleting.contains(currentChar)) {
                    out.write(currentChar);
                }
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
