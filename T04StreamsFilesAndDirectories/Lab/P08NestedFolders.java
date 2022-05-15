package T04StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class P08NestedFolders {
    public static void main(String[] args) {

        String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\Files-and-Streams";
        File folder = new File(path);

        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(folder);

        int folderCount = 0;

        while (!queue.isEmpty()) {
            File currentFile = queue.poll();

            if (currentFile.isDirectory()) {
                System.out.println(currentFile.getName());
                queue.addAll(List.of(currentFile.listFiles()));
                folderCount++;
            }
        }

        System.out.printf("%d folders", folderCount);
    }
}
