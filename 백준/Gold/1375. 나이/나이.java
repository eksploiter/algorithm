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

        String next() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return null;
            } while (c <= ' ');

            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return Integer.MIN_VALUE;
            } while (c <= ' ');

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
    static HashMap<String, Integer> idMap;
    static String[] nameById;
    static int idCnt = 0;

    // adjacency: head[u] -> (to[idx], next[idx])
    static int[] head, to, next;
    static int edgeCnt = 0;

    // BFS helpers
    static int[] seen;
    static int seenToken = 1;
    static int[] queue;

    static int getId(String s) {
        Integer v = idMap.get(s);
        if (v != null) return v;
        int id = idCnt++;
        idMap.put(s, id);
        nameById[id] = s;
        return id;
    }

    static void addEdge(int u, int v) {
        to[edgeCnt] = v;
        next[edgeCnt] = head[u];
        head[u] = edgeCnt;
        edgeCnt++;
    }

    static boolean reachable(int start, int target) {
        if (start == target) return true;

        int token = ++seenToken;
        int front = 0, back = 0;

        queue[back++] = start;
        seen[start] = token;

        while (front < back) {
            int cur = queue[front++];
            for (int e = head[cur]; e != -1; e = next[e]) {
                int nx = to[e];
                if (nx == target) return true;
                if (seen[nx] != token) {
                    seen[nx] = token;
                    queue[back++] = nx;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        N = fs.nextInt();
        M = fs.nextInt();

        int initCap = (int)Math.min(1_500_000L, (long)N * 4L / 3L + 16L);
        idMap = new HashMap<>(initCap, 0.75f);

        nameById = new String[N];
        head = new int[N];
        Arrays.fill(head, -1);

        to = new int[M];
        next = new int[M];

        seen = new int[N];
        queue = new int[N];

        // 관계 입력: a b  =>  a가 b보다 나이 많음 => a -> b
        for (int i = 0; i < M; i++) {
            String a = fs.next();
            String b = fs.next();
            int u = getId(a);
            int v = getId(b);
            addEdge(u, v);
        }

        int Q = fs.nextInt();
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            String a = fs.next();
            String b = fs.next();

            Integer ua = idMap.get(a);
            Integer vb = idMap.get(b);

            if (ua == null || vb == null || ua.intValue() == vb.intValue()) {
                out.append("gg");
            } else {
                int u = ua, v = vb;
                boolean uv = reachable(u, v);
                boolean vu = reachable(v, u);

                if (uv ^ vu) {
                    out.append(nameById[uv ? u : v]);
                } else {
                    out.append("gg");
                }
            }

            if (i + 1 < Q) out.append('\n');
        }

        System.out.print(out);
    }
}