import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board = new int[5][5];
    static boolean found = false;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void dfs(int x, int y, int moves, int apples) {
        if (apples >= 2) {
            found = true;
            return;
        }
        if (moves == 3) {
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if (board[nx][ny] == -1) continue;

            int temp = board[nx][ny];
            board[x][y] = -1;
            dfs(nx, ny, moves + 1, apples + (temp == 1 ? 1 : 0));
            board[x][y] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] start = br.readLine().split(" ");
        int r = Integer.parseInt(start[0]);
        int c = Integer.parseInt(start[1]);

        dfs(r, c, 0, 0);

        System.out.println(found ? 1 : 0);
    }
}
