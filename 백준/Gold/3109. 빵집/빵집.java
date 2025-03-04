import java.io.*;
import java.util.*;

public class Main {
    static int R, C; // 행, 열 크기
    static char[][] grid; // 격자
    static boolean[][] visited; // 방문 여부
    static int[] dx = {-1, 0, 1}; // 위, 오른쪽, 아래 이동 (우선순위: ↗ → ↘)
    static int[] dy = {1, 1, 1}; // 오른쪽 이동
    static int result = 0; // 연결된 파이프 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행(R)과 열(C) 입력 받기
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 격자 입력받기
        grid = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        // 각 행의 첫 번째 열에서 출발하여 파이프 연결 시도
        for (int i = 0; i < R; i++) {
            if (grid[i][0] == '.') { // 시작점이 빈칸인 경우만 탐색
                if (dfs(i, 0)) {
                    result++; // 연결된 파이프라인 개수 증가
                }
            }
        }

        // 결과 출력
        System.out.println(result);
    }

    // DFS + 백트래킹
    static boolean dfs(int x, int y) {
        // 오른쪽 끝에 도착하면 성공
        if (y == C - 1) {
            return true;
        }

        // 우선순위(↗ → ↘)로 탐색
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어나지 않고, 빈칸이며, 방문하지 않았다면 탐색
            if (nx >= 0 && nx < R && ny < C && grid[nx][ny] == '.' && !visited[nx][ny]) {
                visited[nx][ny] = true; // 방문 체크

                if (dfs(nx, ny)) { // 재귀적으로 탐색하여 연결되면 True 반환
                    return true;
                }
            }
        }

        return false; // 연결 불가능하면 False 반환
    }
}
