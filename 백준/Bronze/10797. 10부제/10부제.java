import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int a = Integer.parseInt(br.readLine());
        int count = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (a == b) {
                count++;
            }
        }

        System.out.println(count);
    }
}