package T04StreamsFilesAndDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P04CountCharacterTypes {
    public static void main(String[] args) {

        String pathIn = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        Path path = Path.of(pathIn);
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try {
            List<String> list = Files.readAllLines(path);
            for (String currentElement : list) {
                for (int i = 0; i < currentElement.length(); i++) {
                    char currentChar = currentElement.charAt(i);

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

            String outPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
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
