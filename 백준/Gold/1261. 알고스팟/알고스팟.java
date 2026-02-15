import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static final int INF = 1_000_000_000;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y;
        Node(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < M; j++) map[i][j] = s.charAt(j) - '0';
        }

        dist = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], INF);

        Deque<Node> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.addFirst(new Node(0, 0));

        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();
            int x = cur.x, y = cur.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                int w = map[nx][ny]; // 0이면 그대로, 1이면 벽 하나 부숨
                int nd = dist[x][y] + w;

                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    if (w == 0) dq.addFirst(new Node(nx, ny));
                    else dq.addLast(new Node(nx, ny));
                }
            }
        }

        System.out.println(dist[N - 1][M - 1]);
    }
}
