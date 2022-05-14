package T04StreamsFilesAndDirectories.Lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class PRewritingOfInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Path inPath = Paths.get("D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt");
        Path outPath = Paths.get("D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt");

        try {
            List<String> files = Files.readAllLines(inPath);
            Files.write(outPath, files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
