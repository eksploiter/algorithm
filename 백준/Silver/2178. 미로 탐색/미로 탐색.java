import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static int[][] dist;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine(); // 입력 값에 띄어쓰기가 없다.
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
                dist[i][j] = -1; // 방문하지 않은 곳을 -1로 만든다.
            }
        }

        bfs(0, 0);

        System.out.println(dist[n - 1][m - 1] + 1);
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 벽이거나 이미 방문 했거나 
                if (board[nx][ny] != 1 || dist[nx][ny] >= 0) continue;

                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}