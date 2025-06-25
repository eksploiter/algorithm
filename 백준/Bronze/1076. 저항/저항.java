import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> colors = Arrays.asList(
            "black",  // 0
            "brown",  // 1
            "red",    // 2
            "orange", // 3
            "yellow", // 4
            "green",  // 5
            "blue",   // 6
            "violet", // 7
            "grey",   // 8
            "white"   // 9
        );

        String first  = br.readLine().trim();
        String second = br.readLine().trim();
        String third  = br.readLine().trim();

        int d1 = colors.indexOf(first);
        int d2 = colors.indexOf(second);

        int exponent = colors.indexOf(third);

        long value = d1 * 10L + d2;

        long multiplier = 1;
        for (int i = 0; i < exponent; i++) {
            multiplier *= 10;
        }

        System.out.println(value * multiplier);
    }
}
