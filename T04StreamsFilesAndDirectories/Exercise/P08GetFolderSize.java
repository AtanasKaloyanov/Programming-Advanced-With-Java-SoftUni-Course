package T04StreamsFilesAndDirectories.Exercise;

import java.io.File;

public class P08GetFolderSize {
    private static final String path = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
    public static void main(String[] args) {
        // 1. Creating a file and then its children
          File file = new File(path);
          File[] files = file.listFiles();
          int sum = 0;

          // 2. Looping and accumulating every file's length
        for (File currentFile : files) {
            sum += currentFile.length();
        }

        // 3. Output printing:
        System.out.printf("Folder size: %d", sum);
    }
}
