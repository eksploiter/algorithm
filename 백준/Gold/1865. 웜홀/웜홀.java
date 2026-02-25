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

    static class Edge {
        int from, to, w;
        Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = fs.nextInt();
        while (T-- > 0) {
            int N = fs.nextInt();
            int M = fs.nextInt();
            int W = fs.nextInt();

            List<Edge> edges = new ArrayList<>(2 * M + W);

            for (int i = 0; i < M; i++) {
                int s = fs.nextInt();
                int e = fs.nextInt();
                int t = fs.nextInt();
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t));
            }

            for (int i = 0; i < W; i++) {
                int s = fs.nextInt();
                int e = fs.nextInt();
                int t = fs.nextInt();
                edges.add(new Edge(s, e, -t));
            }

            long[] dist = new long[N + 1];
            Arrays.fill(dist, 0L);

            boolean hasNegCycle = false;
            for (int i = 1; i <= N; i++) {
                boolean updated = false;
                for (Edge ed : edges) {
                    long nd = dist[ed.from] + ed.w;
                    if (dist[ed.to] > nd) {
                        dist[ed.to] = nd;
                        updated = true;
                        if (i == N) {
                            hasNegCycle = true;
                            break;
                        }
                    }
                }
                if (hasNegCycle) break;
                if (!updated) break;
            }

            sb.append(hasNegCycle ? "YES\n" : "NO\n");
        }

        System.out.print(sb.toString());
    }
}