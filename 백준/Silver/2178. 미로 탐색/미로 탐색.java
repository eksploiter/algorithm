import java.io.*;
import java.util.*;

public class Main {
    static int[][] miro;
    static int[][] dist;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        miro = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j) - '0';
                dist[i][j] = -1;
            }
        }

        bfs(0,0);
        System.out.println(dist[n - 1][m - 1] + 1);
        // 배열이 (0,0) 부터 사작하고 
        // (0,0)에서 출발을 하기 때문에 시작점도 거리에 포함해야 하므로 +1을 해야한다.
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
                if (dist[nx][ny] >= 0 || miro[nx][ny] != 1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}