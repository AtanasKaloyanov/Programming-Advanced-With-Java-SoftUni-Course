package T04StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    // 1. Paths const initializing
    private static String inputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\input.txt";
    private static String outputPath = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Lab\\Files\\03.CopyBytesOutput.txt";

    public static void main(String[] args) throws IOException {
        // 2. try-catch-finally algorithm for printing
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(inputPath);
            fos = new FileOutputStream(outputPath);

            int currentElement = fis.read();
            while (currentElement != -1) {
                // 2.1. If the currentElement is new line or space
                // casting the element to char and writing it
                if (currentElement == 10 || currentElement == 32) {
                    char elementAsChar = (char) currentElement;
                    fos.write(elementAsChar);
                    // 2.2. In other case getting the element as string
                    // then as bytes array
                    // and  finally writing the bytes
                } else {
                    String numberAsText = String.valueOf(currentElement);
                    byte[] bytes = numberAsText.getBytes();
                    fos.write(bytes);
                }
                currentElement = fis.read();
            }
        } catch (IOException e) {
            System.out.print(e.getMessage());
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
