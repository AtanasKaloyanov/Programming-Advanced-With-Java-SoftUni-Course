package T04StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {

        String inPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        String outPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt";

        try {
            FileInputStream in = new FileInputStream(inPath);
            Scanner scanner = new Scanner(in);

            FileOutputStream out = new FileOutputStream(outPath);
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