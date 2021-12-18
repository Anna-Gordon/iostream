import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(findMultiplesInRange("src/input.txt"));
    }

    private static String findMultiplesInRange(String source) throws IOException {

        // read number and range from file
        Reader fis = new FileReader(source); // open input stream
        char[] buffer = new char[8];
        int length;

        int number = 0;
        int range = 0;

        while ((length = fis.read(buffer)) > 0) {
            String string = new String(buffer, 0, length);

            number = Integer.parseInt(string.substring(0, string.indexOf(' ')));
            range = Integer.parseInt(string.substring(string.indexOf(' ') + 1));

            System.out.println("Find all multiples of " + number + " below " + range);
        }

        int[] result = new int[100]; // array of multiples
        int j = 0;

        for (int i = 1; i <= range; i++) {
            if (i % number == 0) {
                Arrays.fill(result, j, j + 1, i);
                j++;
            } else continue;
        }

        fis.close();
        return Arrays.toString(result).substring(1, Arrays.toString(result).indexOf(", 0"));

    }

}
