import java.io.*;
import java.util.*;

public class Main {
    static final class FastScanner {
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
            do { c = readByte(); } while (c <= ' ' && c != -1);
            long sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ' && c != -1);
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int N = (int) fs.nextLong();
        int M = (int) fs.nextLong();

        char[][] grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = fs.next();
            grid[i] = line.toCharArray();
        }

        // dist[x][y][b] : distance (0 means unvisited)
        int[][][] dist = new int[N][M][2];

        // queue arrays (size up to N*M*2)
        int max = N * M * 2;
        int[] qx = new int[max];
        int[] qy = new int[max];
        int[] qb = new int[max];
        int head = 0, tail = 0;

        dist[0][0][0] = 1;
        qx[tail] = 0; qy[tail] = 0; qb[tail] = 0; tail++;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (head < tail) {
            int x = qx[head];
            int y = qy[head];
            int b = qb[head];
            int cur = dist[x][y][b];
            head++;

            if (x == N - 1 && y == M - 1) {
                System.out.println(cur);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                char cell = grid[nx][ny];

                if (cell == '0') {
                    if (dist[nx][ny][b] == 0) {
                        dist[nx][ny][b] = cur + 1;
                        qx[tail] = nx; qy[tail] = ny; qb[tail] = b; tail++;
                    }
                } else { // cell == '1'
                    if (b == 0 && dist[nx][ny][1] == 0) {
                        dist[nx][ny][1] = cur + 1;
                        qx[tail] = nx; qy[tail] = ny; qb[tail] = 1; tail++;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}