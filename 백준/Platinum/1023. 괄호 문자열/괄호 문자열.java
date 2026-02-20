import java.io.*;
import java.util.*;

public class Main {
    static final long INF = Long.MAX_VALUE / 4;

    static long capAdd(long a, long b) {
        long s = a + b;
        if (s < 0 || s > INF) return INF;
        return s;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken()); // 0-index

        // pow2[i] = 2^i
        long[] pow2 = new long[N + 1];
        pow2[0] = 1;
        for (int i = 1; i <= N; i++) {
            pow2[i] = pow2[i - 1] * 2;
            if (pow2[i] > INF) pow2[i] = INF;
        }

        long[][] good = new long[N + 1][N + 2];
        for (int bal = 0; bal <= N + 1; bal++) good[0][bal] = (bal == 0 ? 1 : 0);

        for (int rem = 1; rem <= N; rem++) {
            for (int bal = 0; bal <= N; bal++) {
                long v = good[rem - 1][bal + 1];
                if (bal > 0) v = capAdd(v, good[rem - 1][bal - 1]);
                good[rem][bal] = v;
            }
        }

        long totalBad = pow2[N] - good[N][0];
        if (K < 0 || K >= totalBad) {
            System.out.println("-1");
            return;
        }

        StringBuilder ans = new StringBuilder();
        int bal = 0;
        boolean broken = false;

        for (int pos = 0; pos < N; pos++) {
            int rem = N - pos - 1;

            long badIfOpen;
            if (broken) {
                badIfOpen = pow2[rem];
            } else {
                int nb = bal + 1;
                long goodAfter = (nb <= N ? good[rem][nb] : 0);
                badIfOpen = pow2[rem] - goodAfter;
            }

            if (K < badIfOpen) {
                ans.append('(');
                if (!broken) bal++;
            } else {
                K -= badIfOpen;
                ans.append(')');

                if (!broken) {
                    if (bal == 0) {
                        broken = true;
                    } else {
                        bal--;
                    }
                }
            }
        }

        System.out.println(ans.toString());
    }
}