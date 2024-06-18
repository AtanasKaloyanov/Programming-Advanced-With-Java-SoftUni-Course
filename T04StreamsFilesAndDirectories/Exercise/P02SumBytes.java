package T04StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02SumBytes {
    public static void main(String[] args) {
        String path = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
      try {
          // 1. Algorithm for reading every line with bufferedReader and adding its
          // Ascii sum to an accumulative variable
          FileReader fileReader = new FileReader(path);
          BufferedReader bufferedReader = new BufferedReader(fileReader);

          long sum = 0;
          String line = bufferedReader.readLine();
          while (line != null) {

              for (int i = 0; i < line.length(); i++) {
                  char currentChar = line.charAt(i);
                  sum += currentChar;
              }

              line = bufferedReader.readLine();
          }
          fileReader.close();
          bufferedReader.close();
          System.out.println(sum);
      } catch (IOException e) {
          e.printStackTrace();
      }
    }
}
