package T04StreamsFilesAndDirectories.Lab;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {

        File file = new File("D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File currentFile : files) {
                    if (!currentFile.isDirectory()) {
                        System.out.printf("%s: [%s]%n", currentFile.getName(), currentFile.length());
                    }
                }
            }
        }
    }
}
