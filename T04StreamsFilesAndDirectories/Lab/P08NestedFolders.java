package T04StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class P08NestedFolders {
    private static String path = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\Files-and-Streams";

    public static void main(String[] args) {
        File folder = new File(path);

        // bfs algorithm
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(folder);
        int folderCounter = 0;

        while (!queue.isEmpty()) {
            File currentFile = queue.poll();
            if (currentFile.isDirectory()) {
                System.out.println(currentFile.getName());
                queue.addAll(List.of(currentFile.listFiles()));
                folderCounter++;
            }
        }

        System.out.printf("%d folders", folderCounter);
    }
}
