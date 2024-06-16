package T04StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class P05WriteEveryThirdLineSecondSolution {
    public static void main(String[] args) {
        // 1. Constants for input and output initializing
        String inPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\input.txt";
        String outPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\05.WriteEveryThirdLineOutput.txt";

        // 2. Try-catch algorithm
        try {
            FileReader in = new FileReader(inPath);
            FileWriter out = new FileWriter(outPath);

            BufferedReader bufferedReader = new BufferedReader(in);
            PrintWriter printOut = new PrintWriter(out);

            String input = bufferedReader.readLine();
            int counter = 1;

            while (input != null) {
                if (counter % 3 == 0) {
                    printOut.println(input);
                }

                counter++;
                input = bufferedReader.readLine();
            }
            printOut.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
