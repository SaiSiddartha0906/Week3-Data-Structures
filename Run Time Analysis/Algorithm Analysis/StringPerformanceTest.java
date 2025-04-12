import java.util.Random;

public class StringPerformanceTest {

    public static String[] generateStrings(int count, int length) {
        String[] strings = new String[count];
        Random random = new Random();
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        for (int i = 0; i < count; i++) {
            StringBuilder sb = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            strings[i] = sb.toString();
        }
        return strings;
    }

    public static void testString(String[] strings) {
        long startTime = System.nanoTime();

        String result = "";
        for (String str : strings) {
            result += str;
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken by String concatenation: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    public static void testStringBuilder(String[] strings) {
        long startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder(); // Mutable object
        for (String str : strings) {
            sb.append(str);
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder concatenation: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    public static void testStringBuffer(String[] strings) {
        long startTime = System.nanoTime();

        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }

        long endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer concatenation: " + ((endTime - startTime) / 1_000_000) + " ms");
    }

    public static void main(String[] args) {
        String[] strings = generateStrings(1_000_000, 10);

        System.out.println("Testing with 1,000,000 strings:");
        /*testString(strings);*/
        testStringBuilder(strings);
        testStringBuffer(strings);
    }
}