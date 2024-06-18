package T04StreamsFilesAndDirectories.Exercise;

import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P01SumLinesSecondSolution {
    public static void main(String[] args) {

        String pathString = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            Path path = Path.of(pathString);
            List<String> allLines = Files.readAllLines(path);

            allLines.stream()
                    .map(line ->line.toCharArray())
                    .forEach(array -> {
                        int sum = 0;
                        for (char currentChar : array) {
                            sum += currentChar;
                        }
                        System.out.println(sum);
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
