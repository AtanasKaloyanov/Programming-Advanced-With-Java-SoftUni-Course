package T04StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01SumLines {
    public static void main(String[] args) {

        String inputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        // 1. Algorithm for reading every line with bufferedReader and adding its
        // Ascii sum to an accumulative variable
        try {
            FileReader fileReader = new FileReader(inputPath);
            BufferedReader bf = new BufferedReader(fileReader);

            String currentLine = bf.readLine();
            while (currentLine != null) {
                long currentSum = 0;
                for (int i = 0; i < currentLine.length() ; i++) {
                    int currentChar = currentLine.charAt(i);
                    currentSum += currentChar;
                }
                System.out.println(currentSum);
                currentLine = bf.readLine();
            }

            fileReader.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
