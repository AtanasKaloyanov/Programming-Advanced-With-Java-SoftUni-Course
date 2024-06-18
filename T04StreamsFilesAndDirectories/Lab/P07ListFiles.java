package T04StreamsFilesAndDirectories.Lab;

import java.io.File;

public class P07ListFiles {
    private static String path = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\Files-and-Streams";
    public static void main(String[] args) {
        // 1. Creating a file object and checking if it exists and if it is directory
        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                // 2. Creating an array, looping through every element and if it isn't directory printing
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
