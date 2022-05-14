package T04StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {

        String inPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        String outPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt";

        try {
            FileReader in = new FileReader(inPath);
            Scanner scanner = new Scanner(in);

            FileWriter out = new FileWriter(outPath);
            PrintWriter printOut = new PrintWriter(out);

            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {
                    int currentNumber = scanner.nextInt();
                    printOut.println(currentNumber);
                }

                scanner.next();
            }
            printOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}