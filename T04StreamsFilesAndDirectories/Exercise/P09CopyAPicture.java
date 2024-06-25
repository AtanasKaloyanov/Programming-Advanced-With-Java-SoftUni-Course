package T04StreamsFilesAndDirectories.Exercise;

import java.io.*;

public class P09CopyAPicture {
    private static final String PIC_PATH_Input = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\javaVersusGirlfriend.png";
    private static final String PIC_PATH_OUTPUT = "D:\\Programming\\Projects\\Programming Advanced\\src\\T04StreamsFilesAndDirectories\\Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\javaVersusGirlfriendCopy.png";

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(PIC_PATH_Input);
            FileOutputStream fos = new FileOutputStream(PIC_PATH_OUTPUT);

            int currentByte = fis.read();
            while (currentByte != -1) {
                fos.write(currentByte);
                currentByte = fis.read();
            }

            fis.close();
        } catch (IOException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }
}
