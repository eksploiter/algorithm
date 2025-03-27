import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N]; // 메모이제이션

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = 0;

        // 모든 좌표에서 dfs 수행해서 최대값 갱신
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        System.out.println(result);
    }

    static int dfs(int x, int y) {
        // 이미 방문해서 계산된 값이면 바로 반환
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        // 최소 1일은 살아야 함 (자기 자신)
        dp[x][y] = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 범위 안이고, 현재보다 더 많은 대나무가 있는 곳만 이동 가능
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] > map[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
                }
            }
        }

        return dp[x][y];
    }
}
