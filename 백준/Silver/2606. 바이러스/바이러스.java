import java.util.*;

public class Main {
    static boolean[] visited;
    static List<List<Integer>> network = new ArrayList<>();
    static int infectedCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int computerCount = sc.nextInt(); // 컴퓨터의 수
        int pairCount = sc.nextInt(); // 연결된 컴퓨터 쌍의 수

        visited = new boolean[computerCount + 1];

        // 네트워크 초기화
        for (int i = 0; i <= computerCount; i++) {
            network.add(new ArrayList<>());
        }

        // 네트워크 입력 받기
        for (int i = 0; i < pairCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            network.get(a).add(b);
            network.get(b).add(a);
        }

        // DFS 실행
        dfs(1);

        // 결과 출력
        System.out.println(infectedCount - 1); // 1번 컴퓨터 제외
    }

    // DFS 메소드
    static void dfs(int computer) {
        visited[computer] = true;
        infectedCount++;

        for (int next : network.get(computer)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
