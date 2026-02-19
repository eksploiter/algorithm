import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

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
            do { c = readByte(); } while (c <= ' ' && c != -1);
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

    static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static long pack(int dy, int dx) {
        return (((long) dy) << 32) ^ (dx & 0xffffffffL);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = fs.nextInt();
            y[i] = fs.nextInt();
        }

        int ans = 0;

        HashMap<Long, Integer> map = new HashMap<>(n * 2);

        for (int i = 0; i < n; i++) {
            map.clear();
            int bestHere = 1; // i만 포함

            for (int j = i + 1; j < n; j++) {
                int dx = x[j] - x[i];
                int dy = y[j] - y[i];

                if (dx == 0) {
                    // 수직선: (1,0)으로 통일
                    dy = 1;
                    dx = 0;
                } else if (dy == 0) {
                    // 수평선: (0,1)으로 통일
                    dy = 0;
                    dx = 1;
                } else {
                    int g = gcd(dy, dx);
                    dy /= g;
                    dx /= g;

                    // 부호 통일: dx > 0이 되도록
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                }

                long key = pack(dy, dx);
                int cnt = map.getOrDefault(key, 0) + 1;
                map.put(key, cnt);

                bestHere = Math.max(bestHere, cnt + 1);
            }

            ans = Math.max(ans, bestHere);
        }

        if (ans < 3) System.out.print(-1);
        else System.out.print(ans);
    }
}
