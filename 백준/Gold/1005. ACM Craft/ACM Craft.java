import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] buildTime = new int[N + 1];
            int[] indegree = new int[N + 1];
            int[] dp = new int[N + 1];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph.get(u).add(v);
                indegree[v]++;
            }

            int W = Integer.parseInt(br.readLine());

            // 위상 정렬
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                    dp[i] = buildTime[i];
                }
            }

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : graph.get(u)) {
                    dp[v] = Math.max(dp[v], dp[u] + buildTime[v]);
                    if (--indegree[v] == 0) {
                        q.add(v);
                    }
                }
            }

            sb.append(dp[W]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
