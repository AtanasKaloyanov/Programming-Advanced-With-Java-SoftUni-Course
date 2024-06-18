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
        // 1. file reading and writing alg
        Path inPath = Paths.get("D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\input.txt");
        Path outPath = Paths.get("D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\06.SortLinesOutput.txt");
        try {
            List<String> list = Files.readAllLines(inPath);
            Collections.sort(list);
            Files.write(outPath, list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
