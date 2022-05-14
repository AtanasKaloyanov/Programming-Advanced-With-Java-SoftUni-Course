package T04StreamsFilesAndDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class P06SortLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Path inPath = Paths.get("D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt");
        Path outPath = Paths.get("D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt");

        try {
            List<String> list = Files.readAllLines(inPath);
            Collections.sort(list);
            Files.write(outPath, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
