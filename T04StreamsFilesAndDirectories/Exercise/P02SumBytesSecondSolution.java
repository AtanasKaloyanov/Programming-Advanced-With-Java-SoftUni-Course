package T04StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class P02SumBytesSecondSolution {
    public static void main(String[] args) {

        String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            Path inPath = Path.of(path);
            byte[] bytes = Files.readAllBytes(inPath);

            long sum = 0;
            for (byte currentByte : bytes) {
                if (currentByte != 10 && currentByte != 13) {
                    sum += currentByte;
                }
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
