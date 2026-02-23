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

    static int N, M;
    static int[][] a;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        M = fs.nextInt();
        a = new int[N][M];

        int cheese = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = fs.nextInt();
                if (a[i][j] == 1) cheese++;
            }
        }

        if (cheese == 0) {
            System.out.println(0);
            return;
        }

        int hours = 0;

        while (cheese > 0) {
            // 1) 외부 공기 BFS (0,0에서 시작 가능: 가장자리에 치즈 없음)
            boolean[][] outside = new boolean[N][M];
            ArrayDeque<int[]> q = new ArrayDeque<>();
            outside[0][0] = true;
            q.add(new int[]{0, 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (outside[nx][ny]) continue;
                    if (a[nx][ny] != 0) continue; // 공기(0)만 확장
                    outside[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

            // 2) 이번 시간에 녹을 치즈 찾기 (외부 공기와 2면 이상 접촉)
            ArrayList<int[]> melt = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (a[i][j] != 1) continue;
                    int contact = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d], ny = j + dy[d];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                        if (outside[nx][ny]) contact++;
                    }
                    if (contact >= 2) melt.add(new int[]{i, j});
                }
            }

            // 3) 녹이기
            for (int[] p : melt) {
                int x = p[0], y = p[1];
                if (a[x][y] == 1) {
                    a[x][y] = 0;
                    cheese--;
                }
            }

            hours++;
        }

        System.out.println(hours);
    }
}