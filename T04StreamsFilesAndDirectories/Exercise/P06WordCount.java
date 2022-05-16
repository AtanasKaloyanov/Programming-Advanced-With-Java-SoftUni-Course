package T04StreamsFilesAndDirectories.Exercise;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    public static void main(String[] args) {

        String pathToWords = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        Path path = Path.of(pathToWords);

        String pathToText = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        Path secondPath = Path.of(pathToText);

        Map<String, Integer> map = new HashMap<>();

        try {
            List<String> list = Files.readAllLines(path);
            for (String currentLine : list) {
                String[] array = currentLine.split(" ");

                for (int i = 0; i < array.length; i++) {
                    String currentWord = array[i];
                    map.put(currentWord, 0);
                }

                List<String> secondList = Files.readAllLines(secondPath);
                for (String currWord : secondList) {
                    String[] secondArray = currWord.split("[., ]");
                    for (int i = 0; i < secondArray.length; i++) {
                        String current = secondArray[i];
                        if (map.containsKey(current)) {
                            map.put(current, map.get(current) + 1);
                        }
                    }
                }

            }

            String outPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";

            FileWriter fileWriter = new FileWriter(outPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            map.entrySet().stream().sorted( (firstEntry, secondEntry) -> secondEntry.getValue().compareTo(firstEntry.getValue()))
                    .forEach(entry -> {
                try {
                    bufferedWriter.write(entry.getKey() + " - " + entry.getValue());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
