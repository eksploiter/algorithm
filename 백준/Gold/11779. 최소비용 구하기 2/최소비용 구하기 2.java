import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] prev = new int[n + 1];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        dist[start] = 0;
        pq.offer(new long[]{0, start});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long cost = cur[0];
            int u = (int) cur[1];
            if (cost > dist[u]) continue;

            for (Edge e : graph.get(u)) {
                int v = e.to;
                long nc = cost + e.cost;
                if (nc < dist[v]) {
                    dist[v] = nc;
                    prev[v] = u;
                    pq.offer(new long[]{nc, v});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append('\n');

        List<Integer> path = new ArrayList<>();
        for (int cur = end; cur != 0; cur = prev[cur]) {
            path.add(cur);
            if (cur == start) break;
        }
        Collections.reverse(path);

        sb.append(path.size()).append('\n');
        for (int node : path) {
            sb.append(node).append(' ');
        }
        System.out.println(sb);
    }
}
