package T04StreamsFilesAndDirectories.Exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipFile {
    private static final String FILE1_PATH = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\file1.txt";
    private static final String OUTPUT_PATH = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\files.zip";

    public static void main(String[] args) {

        try {
            // 1. Creating a output stream, a zip file and adding the zip file to the
            // output stream
            FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_PATH);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
            ZipEntry zipEntry = new ZipEntry("file1.txt");
            zipOutputStream.putNextEntry(zipEntry);

            // 2. Creating a FileInput stream, reading the input byte by byte and writing
            // every byte via ZipOutput Stream
            FileInputStream fileInputStream = new FileInputStream(FILE1_PATH);
            int currentByte = fileInputStream.read();

            while (currentByte != -1) {
                zipOutputStream.write(currentByte);
                currentByte = fileInputStream.read();
            }

           // 3. Closing the zipOutputStream
            zipOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
