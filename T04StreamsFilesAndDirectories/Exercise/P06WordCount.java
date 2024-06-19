package T04StreamsFilesAndDirectories.Exercise;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P06WordCount {
    private static String pathToWords = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
    private static String pathToText = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
    private static String outPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt";
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // 1. Adding the word to a map
        Path path = Path.of(pathToWords);
        Path secondPath = Path.of(pathToText);

        try {
            List<String> list = Files.readAllLines(path);
            for (String currentLine : list) {
                String[] array = currentLine.split(" ");

                for (int i = 0; i < array.length; i++) {
                    String currentWord = array[i];
                    map.put(currentWord, 0);
                }

                // 2. Adding the occurrences
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

            // 3. Printing
            FileWriter fileWriter = new FileWriter(outPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            map.entrySet().stream()
                    .sorted(occurencesComparator())
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

    private static Comparator<Map.Entry<String, Integer>> occurencesComparator() {
        return (firstEntry, secondEntry) -> secondEntry.getValue().compareTo(firstEntry.getValue());
    }
}
