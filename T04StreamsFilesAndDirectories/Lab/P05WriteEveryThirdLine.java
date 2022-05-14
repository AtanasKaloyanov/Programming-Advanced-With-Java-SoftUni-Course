package T04StreamsFilesAndDirectories.Lab;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {

        String inPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\input.txt";
        String outPath = "D:\\Programming\\SoftUni\\Programming Advanced with Java\\9. Streams, Files and Directories\\Files Tor the Tasks\\output.txt";

        try {
            FileReader in = new FileReader(inPath);
            FileWriter out = new FileWriter(outPath);

            Scanner scanner = new Scanner(in);
            PrintWriter printOut = new PrintWriter(out);

            String input = scanner.nextLine();
            int counter = 1;
            while (scanner.hasNext()) {

                if (counter % 3 == 0) {
                    printOut.println(input);
                }
                    counter++;

               input =  scanner.nextLine();
            }
            printOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
