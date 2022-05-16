package T04StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P07MergeTwoFiles {
    public static void main(String[] args) {

        String firstPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String secondPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        try {
            FileReader fileReader = new FileReader(firstPath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            List<Integer> list = new ArrayList<>();

            String line = bufferedReader.readLine();
            while (line != null) {
                String[] array = line.split("");
                int currentNumber = Integer.parseInt(array[0]);
                list.add(currentNumber);

                line = bufferedReader.readLine();
            }

            FileReader secondFileReader = new FileReader(secondPath);
            BufferedReader secondBufferedReader = new BufferedReader(secondFileReader);

            String secondLine = secondBufferedReader.readLine();
            while (secondLine != null) {
                String[] array = secondLine.split(" ");
                int currentNumber = Integer.parseInt(array[0]);
                list.add(currentNumber);

                secondLine = secondBufferedReader.readLine();
            }

            String printPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\newOutput.txt";
            FileWriter fileWriter = new FileWriter(printPath);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            list.stream().sorted( (firstElement, secondElement) -> {
                return firstElement.compareTo(secondElement);
            }).forEach(number -> printWriter.println(number));

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
