import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = 0;

        // 물 높이를 1~9까지 올려가며 채움
        for (int h = 1; h <= 9; h++) {
            boolean[][] visited = new boolean[N][M];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (!visited[r][c] && map[r][c] < h) {
                        answer += bfsCountIfEnclosed(r, c, h, visited);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static int bfsCountIfEnclosed(int sr, int sc, int h, boolean[][] visited) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayList<int[]> cells = new ArrayList<>();

        visited[sr][sc] = true;
        q.add(new int[]{sr, sc});

        boolean leak = isBorder(sr, sc);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            cells.add(cur);

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] >= h) continue; // 벽(높이 >= h)

                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
                if (isBorder(nr, nc)) leak = true;
            }
        }

        return leak ? 0 : cells.size();
    }

    static boolean isBorder(int r, int c) {
        return r == 0 || r == N - 1 || c == 0 || c == M - 1;
    }
}
