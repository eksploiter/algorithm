import java.io.*;
import java.util.*;

public class Main {

    static int ceilDiv(long a, long b) { // b > 0
        if (a >= 0) return (int)((a + b - 1) / b);
        return (int)(a / b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            a[i] = Integer.parseInt(s.replace(".", ""));
        }

        for (int m = 1; m <= 1000; m++) {
            boolean ok = true;

            for (int i = 0; i < N; i++) {
                long am = (long) a[i] * m;

                int low = ceilDiv(am, 1000L);
                long upperNumer = (long) (a[i] + 1) * m - 1;
                int high = (int) (upperNumer / 1000L);

                if (low < 0) low = 0;
                if (high > 10 * m) high = 10 * m;

                if (low > high) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                System.out.println(m);
                return;
            }
        }
    }
}
