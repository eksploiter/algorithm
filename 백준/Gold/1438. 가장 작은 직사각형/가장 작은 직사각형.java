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

    static int lowerBound(int[] arr, int x) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int query(int[][] ps, int y1, int x1, int y2, int x2) {
        return ps[y2 + 1][x2 + 1] - ps[y1][x2 + 1] - ps[y2 + 1][x1] + ps[y1][x1];
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = fs.nextInt();
        int need = N / 2;

        int[] xsRaw = new int[N];
        int[] ysRaw = new int[N];
        for (int i = 0; i < N; i++) {
            xsRaw[i] = fs.nextInt();
            ysRaw[i] = fs.nextInt();
        }

        int[] xs = xsRaw.clone();
        int[] ys = ysRaw.clone();
        Arrays.sort(xs);
        Arrays.sort(ys);

        xs = Arrays.stream(xs).distinct().toArray();
        ys = Arrays.stream(ys).distinct().toArray();

        int X = xs.length, Y = ys.length;

        int[][] grid = new int[Y][X];
        for (int i = 0; i < N; i++) {
            int xi = lowerBound(xs, xsRaw[i]);
            int yi = lowerBound(ys, ysRaw[i]);
            grid[yi][xi] = 1; // 점은 중복 없음
        }

        // prefix sum
        int[][] ps = new int[Y + 1][X + 1];
        for (int y = 0; y < Y; y++) {
            int rowSum = 0;
            for (int x = 0; x < X; x++) {
                rowSum += grid[y][x];
                ps[y + 1][x + 1] = ps[y][x + 1] + rowSum;
            }
        }

        long ans = Long.MAX_VALUE;

        // fix x1..x2, then find minimal y-range with >= need points using two pointers
        int[] rowCnt = new int[Y];
        for (int x1 = 0; x1 < X; x1++) {
            for (int x2 = x1; x2 < X; x2++) {
                for (int y = 0; y < Y; y++) {
                    rowCnt[y] = query(ps, y, x1, y, x2); // points in this row within [x1..x2]
                }

                int l = 0;
                int sum = 0;
                for (int r = 0; r < Y; r++) {
                    sum += rowCnt[r];
                    while (l <= r && sum - rowCnt[l] >= need) {
                        sum -= rowCnt[l++];
                    }
                    if (sum >= need) {
                        long w = (long) xs[x2] - xs[x1] + 2; // +2 because boundary points excluded
                        long h = (long) ys[r] - ys[l] + 2;
                        long area = w * h;
                        if (area < ans) ans = area;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
