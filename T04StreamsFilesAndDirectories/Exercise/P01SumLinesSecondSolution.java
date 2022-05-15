package T04StreamsFilesAndDirectories.Exercise;

import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P01SumLinesSecondSolution {
    public static void main(String[] args) {

        String pathString = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            Path path = Path.of(pathString);
            List<String> lines = Files.readAllLines(path);


            for (String line : lines) {

                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    sum += currentChar;
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
