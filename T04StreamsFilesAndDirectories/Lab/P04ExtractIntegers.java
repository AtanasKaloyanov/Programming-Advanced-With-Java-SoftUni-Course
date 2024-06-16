package T04StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    // 1. Paths const initializing
    private static String inputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\input.txt";
    private static String outputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\04.ExtractIntegersOutput.txt";

    public static void main(String[] args) {
        Scanner scanner = null;
        PrintWriter pw = null;

        // 2. Try-catch-finally algorithm
        try {
            scanner = new Scanner(new FileReader(inputPath));
            pw = new PrintWriter(new FileWriter(outputPath));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineWords = line.split(" ");

                for (String word : lineWords) {
                    if (isNumber(word)) {
                        pw.println(word);
                    }
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

    private static boolean isNumber(String word) {
        try {
            int number = Integer.parseInt(word);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}