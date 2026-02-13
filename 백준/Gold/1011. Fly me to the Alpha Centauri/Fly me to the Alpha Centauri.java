import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            long d = y - x;

            long k = (long) Math.sqrt(d);   // floor(sqrt(d))
            long k2 = k * k;

            long ans;
            if (d == k2) {
                ans = 2 * k - 1;
            } else if (d <= k2 + k) {
                ans = 2 * k;
            } else {
                ans = 2 * k + 1;
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
