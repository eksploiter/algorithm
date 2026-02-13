import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

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
            do c = readByte();
            while (c <= ' ');

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            do c = readByte();
            while (c <= ' ');

            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int R = fs.nextInt();
        int C = fs.nextInt();

        int[][] a = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = fs.next();
            for (int j = 0; j < C; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        int[][] ul = new int[R][C]; // ↖
        int[][] ur = new int[R][C]; // ↗
        int[][] dl = new int[R][C]; // ↙
        int[][] dr = new int[R][C]; // ↘

        // up-left, up-right
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (a[i][j] == 1) {
                    ul[i][j] = 1 + ((i > 0 && j > 0) ? ul[i - 1][j - 1] : 0);
                    ur[i][j] = 1 + ((i > 0 && j + 1 < C) ? ur[i - 1][j + 1] : 0);
                }
            }
        }

        // down-left, down-right
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                if (a[i][j] == 1) {
                    dl[i][j] = 1 + ((i + 1 < R && j > 0) ? dl[i + 1][j - 1] : 0);
                    dr[i][j] = 1 + ((i + 1 < R && j + 1 < C) ? dr[i + 1][j + 1] : 0);
                }
            }
        }

        int best = 0;

        // (i,j)를 아래 꼭짓점으로 하는 다이아몬드 최대 크기 탐색
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (a[i][j] == 0) continue;

                int maxCand = Math.min(ul[i][j], ur[i][j]);
                for (int k = maxCand; k > best; k--) {
                    int top = i - 2 * (k - 1);
                    if (top < 0) continue;

                    if (dl[top][j] >= k && dr[top][j] >= k) {
                        best = k;
                        break;
                    }
                }
            }
        }

        System.out.println(best);
    }
}
