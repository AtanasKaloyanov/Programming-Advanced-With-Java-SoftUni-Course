package T04StreamsFilesAndDirectories.Exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P07MergeTwoFiles {
    private static String firstPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
    private static String secondPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
    private static String printPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\newOutput.txt";
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        try {
            // 1. Adding the information of the first file into a list
            FileReader fileReader = new FileReader(firstPath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            addingInfo(line, "", list, bufferedReader);

            // 2. Adding the info of the second file into a list
            FileReader secondFileReader = new FileReader(secondPath);
            BufferedReader secondBufferedReader = new BufferedReader(secondFileReader);

            String secondLine = secondBufferedReader.readLine();
            addingInfo(secondLine, " ", list, secondBufferedReader);

            // 3. Sorting and writing
            FileWriter fileWriter = new FileWriter(printPath);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            list.stream().sorted((firstElement, secondElement) -> {
                        return firstElement.compareTo(secondElement);
                    })
                    .forEach(number -> printWriter.println(number));

            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void addingInfo(String line, String regex, List<Integer> list, BufferedReader bufferedReader) throws IOException {
        while (line != null) {
            String[] array = line.split(regex);
            int currentNumber = Integer.parseInt(array[0]);
            list.add(currentNumber);

            line = bufferedReader.readLine();
        }
    }
}
