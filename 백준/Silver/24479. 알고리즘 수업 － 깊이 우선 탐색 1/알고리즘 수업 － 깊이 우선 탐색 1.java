import java.util.*;

public class Main {
    static int[] visitOrder;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int order = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt(); // 정점의 수
        int M = sc.nextInt(); // 간선의 수
        int R = sc.nextInt(); // 시작 정점

        visitOrder = new int[N + 1];
        visited = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 인접 정점 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 수행
        dfs(R);

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    // DFS 메소드
    static void dfs(int node) {
        visited[node] = true;
        visitOrder[node] = order++;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}