import java.io.*;
import java.util.*;

public class Main {
    static class Fireball {
        int r, c, m, s, d;
        Fireball(int r, int c, int m, int s, int d) {
            this.r = r; this.c = c; this.m = m; this.s = s; this.d = d;
        }
    }

    static int N, M, K;
    static List<Fireball> balls = new ArrayList<>();
    static List<Fireball> grid[][]; 
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new ArrayList[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            balls.add(new Fireball(r, c, m, s, d));
        }

        while (K-- > 0) {
            move();
            merge();
        }

        long ans = 0;
        for (Fireball fb : balls) ans += fb.m;
        System.out.println(ans);
    }

    static void move() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j].clear();

        for (Fireball fb : balls) {
            int nr = (fb.r + dr[fb.d] * (fb.s % N) + N * 1000) % N;
            int nc = (fb.c + dc[fb.d] * (fb.s % N) + N * 1000) % N;
            grid[nr][nc].add(new Fireball(nr, nc, fb.m, fb.s, fb.d));
        }

        balls.clear();
    }

    static void merge() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int size = grid[i][j].size();
                if (size == 0) continue;
                if (size == 1) {
                    balls.add(grid[i][j].get(0));
                } else {
                    int mSum = 0, sSum = 0;
                    boolean allEven = true, allOdd = true;
                    for (Fireball fb : grid[i][j]) {
                        mSum += fb.m;
                        sSum += fb.s;
                        if (fb.d % 2 == 0) allOdd = false;
                        else allEven = false;
                    }
                    int nm = mSum / 5;
                    if (nm == 0) continue;
                    int ns = sSum / size;
                    int[] dirs = (allEven || allOdd) ? new int[]{0,2,4,6} : new int[]{1,3,5,7};
                    for (int d : dirs) balls.add(new Fireball(i, j, nm, ns, d));
                }
            }
        }
    }
}
