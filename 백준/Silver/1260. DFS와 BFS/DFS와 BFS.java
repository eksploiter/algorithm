import java.util.*;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    // DFS 함수
    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int next : graph.get(v)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    // BFS 함수
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");

            for (int next : graph.get(v)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 정점의 개수
        int M = sc.nextInt();  // 간선의 개수
        int V = sc.nextInt();  // 시작 정점

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 각 정점의 인접 리스트 정렬 (정점 번호가 작은 것을 우선 방문하기 위함)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 수행
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS 수행
        visited = new boolean[N + 1];
        bfs(V);
    }
}
