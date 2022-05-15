package T04StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) {

        String path = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\10. Exercise - Streams, Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
      try {
          FileReader fileReader = new FileReader(path);
          BufferedReader bufferedReader = new BufferedReader(fileReader);

          int sum = 0;
          String line = bufferedReader.readLine();
          while (line != null) {

              for (int i = 0; i < line.length(); i++) {
                  char currentChar = line.charAt(i);
                  sum += currentChar;
              }

              line = bufferedReader.readLine();
          }
          System.out.println(sum);

      } catch (IOException e) {
          e.printStackTrace();
      }
    }
}
