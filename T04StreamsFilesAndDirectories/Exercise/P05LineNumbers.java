package T04StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class P05LineNumbers {
    private static final String inPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
    private static final String outPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
    public static void main(String[] args) {

        try {
            // reading, changing and writing algorithm
            FileReader fileReader = new FileReader(inPath);
            FileWriter fileWriter = new FileWriter(outPath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            int counter = 1;
            String line = bufferedReader.readLine();
            while (line != null) {
                bufferedWriter.write(counter + ". " + line);
                bufferedWriter.newLine();
                counter++;
                line = bufferedReader.readLine();
            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
