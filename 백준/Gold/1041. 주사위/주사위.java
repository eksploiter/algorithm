import java.io.*;
import java.util.*;

public class Main {
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
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        long N = fs.nextLong();
        long[] d = new long[6];
        long sum = 0;
        long max = 0;
        long min1 = Long.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            d[i] = fs.nextLong();
            sum += d[i];
            max = Math.max(max, d[i]);
            min1 = Math.min(min1, d[i]);
        }

        // N == 1: 5 faces visible => total - max
        if (N == 1) {
            System.out.println(sum - max);
            return;
        }

        // Opposites: (0,5), (1,4), (2,3)
        int[] opp = {5, 4, 3, 2, 1, 0};

        // min2: 최소 (인접한 두 면의 합)
        long min2 = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (j == opp[i]) continue; // opposite => not adjacent
                min2 = Math.min(min2, d[i] + d[j]);
            }
        }

        // min3: 최소 (코너를 이루는 세 면의 합) - 8개 코너 조합
        int A = 0, B = 1, C = 2, D = 3, E = 4, F = 5;
        long min3 = Long.MAX_VALUE;
        int[][] corners = {
                {A, B, C}, {A, B, D}, {A, E, C}, {A, E, D},
                {F, B, C}, {F, B, D}, {F, E, C}, {F, E, D}
        };
        for (int[] c : corners) {
            min3 = Math.min(min3, d[c[0]] + d[c[1]] + d[c[2]]);
        }

        // counts (N >= 2)
        long cnt3 = 4;                          // top corners
        long cnt2 = 8 * N - 12;                 // edges excluding corners
        long cnt1 = 5 * N * N - 16 * N + 12;    // face interiors (top + 4 sides), excluding edges

        long ans = min3 * cnt3 + min2 * cnt2 + min1 * cnt1;
        System.out.println(ans);
    }
}
