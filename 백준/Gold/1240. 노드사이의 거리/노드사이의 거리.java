import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static int N, M;
    static ArrayList<Edge>[] g;

    static int bfsDist(int start, int target) {
        boolean[] vis = new boolean[N + 1];
        int[] dist = new int[N + 1];

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target) return dist[cur];

            for (Edge e : g[cur]) {
                if (vis[e.to]) continue;
                vis[e.to] = true;
                dist[e.to] = dist[cur] + e.w;
                q.add(e.to);
            }
        }
        return -1; // 트리라 항상 도달
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, d));
            g[b].add(new Edge(a, d));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfsDist(a, b)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
