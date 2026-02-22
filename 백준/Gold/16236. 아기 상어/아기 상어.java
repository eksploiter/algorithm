import java.io.*;
import java.util.*;

/**
 * BOJ 16236 - 아기 상어
 * BFS를 매번 수행하여 "가장 가까운(거리) -> 가장 위(행) -> 가장 왼쪽(열)" 물고기를 먹는다.
 */
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

    static int N;
    static int[][] a;
    static int sharkR, sharkC;
    static int sharkSize = 2;
    static int eaten = 0;
    static int time = 0;

    static final int[] dr = {-1, 0, 0, 1};
    static final int[] dc = {0, -1, 1, 0};

    static class Result {
        int r, c, d;
        Result(int r, int c, int d) { this.r = r; this.c = c; this.d = d; }
    }

    static Result bfsFind() {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sharkR, sharkC});
        dist[sharkR][sharkC] = 0;

        int bestD = Integer.MAX_VALUE;
        int bestR = -1, bestC = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int cd = dist[r][c];

            // 이미 더 좋은(짧은) 먹이를 찾았으면 그보다 깊은 탐색은 의미 없음
            if (cd >= bestD) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (dist[nr][nc] != -1) continue;

                // 지나갈 수 있는 조건: 빈칸(0) or 물고기 크기 <= 상어 크기
                if (a[nr][nc] > sharkSize) continue;

                dist[nr][nc] = cd + 1;

                // 먹을 수 있는 조건: 0이 아니고, 물고기 크기 < 상어 크기
                if (a[nr][nc] != 0 && a[nr][nc] < sharkSize) {
                    int nd = dist[nr][nc];
                    if (nd < bestD ||
                            (nd == bestD && (nr < bestR || (nr == bestR && nc < bestC)))) {
                        bestD = nd;
                        bestR = nr;
                        bestC = nc;
                    }
                }

                q.add(new int[]{nr, nc});
            }
        }

        if (bestD == Integer.MAX_VALUE) return null;
        return new Result(bestR, bestC, bestD);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        N = fs.nextInt();
        a = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                a[i][j] = fs.nextInt();
                if (a[i][j] == 9) {
                    sharkR = i; sharkC = j;
                    a[i][j] = 0; // 상어 위치는 빈칸으로 처리
                }
            }
        }

        while (true) {
            Result target = bfsFind();
            if (target == null) break;

            // 이동 및 섭취
            time += target.d;
            sharkR = target.r;
            sharkC = target.c;
            a[sharkR][sharkC] = 0;

            eaten++;
            if (eaten == sharkSize) {
                sharkSize++;
                eaten = 0;
            }
        }

        System.out.print(time);
    }
}