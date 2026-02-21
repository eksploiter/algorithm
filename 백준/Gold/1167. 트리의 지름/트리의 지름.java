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
            do c = readByte();
            while (c <= ' ');

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
        int to;
        int w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static int V;
    static List<Edge>[] g;

    static class Result {
        int node;
        long dist;
        Result(int node, long dist) { this.node = node; this.dist = dist; }
    }

    // 트리이므로 방문만 잘 하면 누적거리 DFS/BFS 아무거나 OK (여기선 스택 기반 DFS)
    static Result farthestFrom(int start) {
        boolean[] vis = new boolean[V + 1];
        long[] dist = new long[V + 1];

        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(start);
        vis[start] = true;

        int farNode = start;
        long farDist = 0;

        while (!st.isEmpty()) {
            int cur = st.pop();
            long curD = dist[cur];

            if (curD > farDist) {
                farDist = curD;
                farNode = cur;
            }

            for (Edge e : g[cur]) {
                if (!vis[e.to]) {
                    vis[e.to] = true;
                    dist[e.to] = curD + e.w;
                    st.push(e.to);
                }
            }
        }

        return new Result(farNode, farDist);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        V = fs.nextInt();

        g = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            int from = fs.nextInt();
            while (true) {
                int to = fs.nextInt();
                if (to == -1) break;
                int w = fs.nextInt();
                g[from].add(new Edge(to, w));
            }
        }

        // 1) 임의의 점(1)에서 가장 먼 점 A
        Result a = farthestFrom(1);
        // 2) A에서 가장 먼 거리 = 지름
        Result b = farthestFrom(a.node);

        System.out.println(b.dist);
    }
}