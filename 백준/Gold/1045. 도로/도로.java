import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int u, v;
        boolean used;
        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int x) {
            if (p[x] == x) return x;
            return p[x] = find(p[x]);
        }
        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (r[a] < r[b]) {
                p[a] = b;
            } else if (r[a] > r[b]) {
                p[b] = a;
            } else {
                p[b] = a;
                r[a]++;
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] mat = new String[N];
        for (int i = 0; i < N; i++) mat[i] = br.readLine().trim();

        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (mat[i].charAt(j) == 'Y') {
                    edges.add(new Edge(i, j));
                }
            }
        }

        if (edges.size() < M) {
            System.out.println(-1);
            return;
        }
        if (M < N - 1) {
            System.out.println(-1);
            return;
        }

        int[] deg = new int[N];
        DSU dsu = new DSU(N);

        int treeEdges = 0;
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                e.used = true;
                deg[e.u]++;
                deg[e.v]++;
                treeEdges++;
                if (treeEdges == N - 1) break;
            }
        }

        if (treeEdges != N - 1) {
            System.out.println(-1);
            return;
        }

        int remain = M - (N - 1);

        if (remain > 0) {
            for (Edge e : edges) {
                if (remain == 0) break;
                if (!e.used) {
                    e.used = true;
                    deg[e.u]++;
                    deg[e.v]++;
                    remain--;
                }
            }
        }

        if (remain != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(deg[i]);
        }
        System.out.println(sb);
    }
}