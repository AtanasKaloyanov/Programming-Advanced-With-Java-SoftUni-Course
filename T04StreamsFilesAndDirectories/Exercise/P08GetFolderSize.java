package T04StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.nio.file.Path;

public class P08GetFolderSize {
    public static void main(String[] args) {

          String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
          File file = new File(path);

          File[] files = file.listFiles();
          int sum = 0;

        for (File currentFile : files) {
            sum += currentFile.length();
        }

        System.out.printf("Folder size: %d", sum);
    }
}
