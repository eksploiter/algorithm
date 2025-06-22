import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("END")) {
                break;
            }

            StringBuilder sb = new StringBuilder(line);
            System.out.println(sb.reverse().toString());
        }
    }
}
