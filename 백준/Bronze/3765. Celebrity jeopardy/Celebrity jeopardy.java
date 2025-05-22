import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new LinkedHashSet<>();
        String line;
        while ((line = br.readLine()) != null) {
            set.add(line);
        }

        for (String s : set) {
            System.out.println(s);
        }
    }
}
