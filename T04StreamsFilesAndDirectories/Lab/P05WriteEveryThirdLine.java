package T04StreamsFilesAndDirectories.Lab;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P05WriteEveryThirdLine {
    // 1. Paths const initializing
    private static String inputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\input.txt";
    private static String outputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\05.WriteEveryThirdLineOutput.txt";

    public static void main(String[] args) {
        Scanner scanner = null;
        PrintWriter pw = null;

        // 2. Try-catch-finally algorithm
        try {
            scanner = new Scanner(new FileReader(inputPath));
            pw = new PrintWriter(new FileWriter(outputPath));

            int counter = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                counter++;
                if (counter % 3 == 0) {
                    pw.println(line);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }

            if (pw != null) {
                pw.close();
            }
        }
    }
}
