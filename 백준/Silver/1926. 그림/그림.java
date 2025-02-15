import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSize = 0;
        int paintNum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 1 || visited[i][j]) continue;
                
                paintNum++;
                maxSize = Math.max(maxSize, bfs(i, j));
            }
        }

        System.out.println(paintNum);
        System.out.println(maxSize);
    }

    public static int bfs(int startX, int startY) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int area = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            area++;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] != 1) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
        return area;
    }
}