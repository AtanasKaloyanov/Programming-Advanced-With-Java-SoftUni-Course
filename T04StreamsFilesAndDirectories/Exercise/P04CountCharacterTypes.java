package T04StreamsFilesAndDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P04CountCharacterTypes {
    private static String pathIn = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
    private static String outPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

    public static void main(String[] args) {
        Path path = Path.of(pathIn);
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try {
            // 1. Reading
            List<String> list = Files.readAllLines(path);
            for (String currentElement : list) {
                for (int i = 0; i < currentElement.length(); i++) {
                    char currentChar = currentElement.charAt(i);

                    // 2. Checking every char
                    switch (currentChar) {
                        case 'a', 'e', 'i', 'o', 'u':
                            vowels++;
                            break;

                        case '!', ',', '.', '?':
                            punctuation++;
                            break;

                        case ' ':
                            continue;

                        default:
                            consonants++;
                            break;
                    }
                }
            }

            // 3. Writing
            FileWriter fileReader = new FileWriter(outPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

            bufferedWriter.write("Vowels: " + vowels);
            bufferedWriter.newLine();
            bufferedWriter.write("Consonants: " + consonants);
            bufferedWriter.newLine();
            bufferedWriter.write("Punctuation: " + punctuation);
            bufferedWriter.newLine();

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
