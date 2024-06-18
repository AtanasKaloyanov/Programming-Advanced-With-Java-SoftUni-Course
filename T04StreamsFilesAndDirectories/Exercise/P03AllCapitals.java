package T04StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {

        String inPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try {
            FileReader fileReader = new FileReader(inPath);
            FileWriter fileWriter = new FileWriter(outPath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String line = bufferedReader.readLine();

            while (line != null) {
                printWriter.println(line.toUpperCase());
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
