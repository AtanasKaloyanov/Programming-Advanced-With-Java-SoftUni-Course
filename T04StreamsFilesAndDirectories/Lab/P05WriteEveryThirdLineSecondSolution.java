package T04StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class P05WriteEveryThirdLineSecondSolution {
    public static void main(String[] args) {

        String inPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        String outPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt";

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
