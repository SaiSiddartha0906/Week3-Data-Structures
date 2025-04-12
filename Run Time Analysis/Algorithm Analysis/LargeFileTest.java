import java.io.*;
import java.util.*;
public class LargeFileTest {
    // Method to generate a large file
    public static void generateLargeFile(String fileName, int fileSizeInMB) throws IOException {
        Random random = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            int totalCharacters = fileSizeInMB * 1024 * 1024;
            for (int i = 0; i < totalCharacters; i++) {
                writer.write(chars.charAt(random.nextInt(chars.length())));
            }
        }

        System.out.println("File generated: " + fileName);
    }


    public static void testFileReader(String fileName) throws IOException {
        long startTime = System.nanoTime();

        try (FileReader fileReader = new FileReader(fileName)) {
            while (fileReader.read() != -1) {

            }
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken by FileReader: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    public static void testInputStreamReader(String fileName) throws IOException {
        long startTime = System.nanoTime();

        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(fileName))) {
            while (inputStreamReader.read() != -1) {

            }
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken by InputStreamReader: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    public static void main(String[] args) {
        try {
            String fileName = "largeFile.txt";
            int fileSizeInMB = 500;

            generateLargeFile(fileName, fileSizeInMB);


            testFileReader(fileName);

            testInputStreamReader(fileName);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}