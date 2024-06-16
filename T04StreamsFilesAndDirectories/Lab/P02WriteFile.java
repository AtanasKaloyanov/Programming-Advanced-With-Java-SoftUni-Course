package T04StreamsFilesAndDirectories.Lab;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P02WriteFile {
    // 1. Creating 3 constants - 2 paths and a set
    private static final String inputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\input.txt";
    private static final String outputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\02.WriteToFileOutput.txt";
    private static Set<Character> escapingChars = new HashSet<>(Set.of(',', '.', '!', '?'));

    public static void main(String[] args) throws IOException {
        // 2. Printing try-catch-finally algorithm
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(inputPath);
            fos = new FileOutputStream(outputPath);
            int currentElement = fis.read();

            while (currentElement != -1) {
                char elementAsChar = (char) currentElement;
                if (!escapingChars.contains(elementAsChar)) {
                    fos.write(elementAsChar);
                }

                currentElement = fis.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
}
