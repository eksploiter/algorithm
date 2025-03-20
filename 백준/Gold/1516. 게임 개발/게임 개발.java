import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 건물 개수
        int[] buildTime = new int[N + 1]; // 각 건물을 짓는 데 걸리는 시간
        int[] inDegree = new int[N + 1]; // 진입 차수 배열
        List<List<Integer>> graph = new ArrayList<>(); // 인접 리스트
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken()); // 건물 짓는 기본 시간
            while (true) {
                int pre = Integer.parseInt(st.nextToken()); // 선행 건물
                if (pre == -1) break; // 종료 조건
                graph.get(pre).add(i); // 선행 건물이 지어져야 i 건물을 지을 수 있음
                inDegree[i]++; // 진입 차수 증가
            }
        }

        // 위상 정렬을 위한 큐
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[N + 1]; // 각 건물이 완성되는 최소 시간

        // 진입 차수가 0인 건물(선행 건물이 없는 건물) 먼저 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = buildTime[i]; // 초기값 설정
            }
        }

        // 위상 정렬 수행
        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 건물

            for (int next : graph.get(now)) {
                // 이전 건물이 완성되어야 현재 건물을 지을 수 있으므로
                // 가장 오래 걸리는 경로를 선택하여 누적
                result[next] = Math.max(result[next], result[now] + buildTime[next]);
                
                // 진입 차수 감소
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }
}
