import java.io.*;
import java.util.*;

public class Main {

    // 빠른 입력
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do c = readByte(); while (c <= ' ' && c != -1);
            long sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int N = fs.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = fs.nextInt();
        int K = fs.nextInt();

        if (K < 3 || K > N) {
            System.out.println(0);
            return;
        }

        Arrays.sort(a);

        int maxSum = 50000 * (K - 1); // (K-1)개 합의 최댓값
        long[][] dp = new long[K][maxSum + 1]; // dp[0..K-1][0..maxSum]
        dp[0][0] = 1;

        long ans = 0;

        for (int i = 0; i < N; i++) {
            int L = a[i];

            // i번째를 가장 긴 변으로 둘 때: 이전 선분들로 (K-1)개 합이 L 초과인 경우
            long add = 0;
            for (int s = L + 1; s <= maxSum; s++) {
                add += dp[K - 1][s];
            }
            ans += add;

            // dp 갱신 (현재 선분을 앞으로 사용할 수 있도록 반영)
            int upperC = Math.min(K - 1, i + 1);
            for (int c = upperC; c >= 1; c--) {
                for (int s = maxSum; s >= L; s--) {
                    dp[c][s] += dp[c - 1][s - L];
                }
            }
        }

        System.out.println(ans);
    }
}