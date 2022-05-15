package T04StreamsFilesAndDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P03AllCapitalsSecondSolution {
    public static void main(String[] args) {

        String inPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try {
            Path path = Path.of(inPath);
            List<String> list = Files.readAllLines(path);

            FileWriter fileWriter = new FileWriter(outPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String currentLine : list) {
                bufferedWriter.write(currentLine.toUpperCase());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
