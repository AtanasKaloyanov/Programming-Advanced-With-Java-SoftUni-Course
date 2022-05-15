package T04StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) {

        String inPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try {
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
