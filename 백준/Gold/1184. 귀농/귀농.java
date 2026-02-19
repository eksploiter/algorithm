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

        int nextInt() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ');

            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static int rectSum(int[][] ps, int r1, int c1, int r2, int c2) {
        // inclusive
        return ps[r2][c2] - ps[r1 - 1][c2] - ps[r2][c1 - 1] + ps[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();

        int[][] ps = new int[N + 1][N + 1]; // prefix sum
        for (int i = 1; i <= N; i++) {
            int rowSum = 0;
            for (int j = 1; j <= N; j++) {
                rowSum += fs.nextInt();
                ps[i][j] = ps[i - 1][j] + rowSum;
            }
        }

        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>(4096);

        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j <= N - 1; j++) {

                map.clear();
                for (int r1 = 1; r1 <= i; r1++) {
                    for (int c1 = 1; c1 <= j; c1++) {
                        int s = rectSum(ps, r1, c1, i, j);
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    }
                }
                for (int r2 = i + 1; r2 <= N; r2++) {
                    for (int c2 = j + 1; c2 <= N; c2++) {
                        int s = rectSum(ps, i + 1, j + 1, r2, c2);
                        ans += map.getOrDefault(s, 0);
                    }
                }

                map.clear();
                for (int r1 = 1; r1 <= i; r1++) {
                    for (int c2 = j + 1; c2 <= N; c2++) {
                        int s = rectSum(ps, r1, j + 1, i, c2);
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    }
                }
                for (int r2 = i + 1; r2 <= N; r2++) {
                    for (int c1 = 1; c1 <= j; c1++) {
                        int s = rectSum(ps, i + 1, c1, r2, j);
                        ans += map.getOrDefault(s, 0);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
