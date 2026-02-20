import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static int[][] dp;              // 0이면 아직 미계산
    static boolean[][] inStack;     // 현재 DFS 경로에 포함되어 있는지
    static boolean infinite = false;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static int dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return 0;
        if (board[x][y] == 'H') return 0;

        if (inStack[x][y]) { // 현재 경로에서 재방문 -> 무한 루프
            infinite = true;
            return 0;
        }

        if (dp[x][y] != 0) return dp[x][y];

        inStack[x][y] = true;

        int step = board[x][y] - '0';
        int best = 0;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir] * step;
            int ny = y + dy[dir] * step;
            int val = dfs(nx, ny);
            if (infinite) { // 이미 무한 판정이면 더 볼 필요 없음
                inStack[x][y] = false;
                return 0;
            }
            best = Math.max(best, val + 1);
        }

        inStack[x][y] = false;
        dp[x][y] = best;
        return best;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) board[i][j] = line.charAt(j);
        }

        dp = new int[N][M];
        inStack = new boolean[N][M];

        int ans = dfs(0, 0);
        System.out.println(infinite ? -1 : ans);
    }
}