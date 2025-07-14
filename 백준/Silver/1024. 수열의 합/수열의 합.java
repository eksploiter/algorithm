import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.parseLong(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean found = false;

        for (int len = L; len <= 100; len++) {
            long numerator = N - (long)len * (len - 1) / 2;
            if (numerator < 0) break;
            if (numerator % len != 0) continue;

            long x = numerator / len;
            if (x < 0) continue;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                sb.append(x + i).append(i < len - 1 ? ' ' : '\n');
            }
            System.out.print(sb);
            found = true;
            break;
        }

        if (!found) {
            System.out.println(-1);
        }
    }
}
