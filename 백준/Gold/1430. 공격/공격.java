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

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int N = fs.nextInt();
        int R = fs.nextInt();
        int D = fs.nextInt();
        int enemyX = fs.nextInt();
        int enemyY = fs.nextInt();

        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = fs.nextInt();
            y[i] = fs.nextInt();
        }

        long R2 = 1L * R * R;

        ArrayList<Integer>[] g = new ArrayList[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                long dx = x[i] - x[j];
                long dy = y[i] - y[j];
                long dist2 = dx * dx + dy * dy;
                if (dist2 <= R2) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }

        // 멀티 소스 BFS: 적 사거리 안에 있는 탑들을 시작점 dist=0
        final int INF = 1_000_000_000;
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            long dx = x[i] - enemyX;
            long dy = y[i] - enemyY;
            long dist2 = dx * dx + dy * dy;
            if (dist2 <= R2) {
                dist[i] = 0;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            int nd = dist[cur] + 1;
            for (int nxt : g[cur]) {
                if (dist[nxt] > nd) {
                    dist[nxt] = nd;
                    q.add(nxt);
                }
            }
        }

        double ans = 0.0;
        for (int i = 0; i < N; i++) {
            if (dist[i] == INF) continue; // 어떤 공격 가능한 탑에도 못 보내면 0
            ans += D / Math.pow(2.0, dist[i]);
        }

        System.out.printf(Locale.US, "%.10f%n", ans);
    }
}
