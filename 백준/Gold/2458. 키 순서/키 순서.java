import java.util.*;

public class Main {
    static int N, M;
    static boolean[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 학생 수
        M = sc.nextInt(); // 비교 횟수
        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int small = sc.nextInt(); // 키가 작은 학생
            int tall = sc.nextInt();  // 키가 큰 학생
            graph[small][tall] = true;
        }

        // Floyd-Warshall: i -> j로 갈 수 있고, j -> k로 갈 수 있다면 i -> k도 true
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }

            if (count == N - 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
