import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 박스별: 몇 가지 색이 들어있는지, 정확히 1가지면 그 색 인덱스
        int[] kindCnt = new int[N];
        int[] onlyColor = new int[N];
        Arrays.fill(onlyColor, -1);

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            int color = -1;
            for (int j = 0; j < M; j++) {
                if (a[i][j] != 0) {
                    cnt++;
                    if (color == -1) color = j;
                }
            }
            kindCnt[i] = cnt;
            if (cnt == 1) onlyColor[i] = color;
        }

        int ans = Integer.MAX_VALUE;

        for (int joker = 0; joker < N; joker++) {
            boolean[] used = new boolean[M]; // 조커 제외 박스에서 해당 색 대표를 이미 둔 적 있는지
            int moves = 0;

            for (int box = 0; box < N; box++) {
                if (box == joker) continue;

                int cnt = kindCnt[box];
                if (cnt == 0) continue;

                if (cnt >= 2) {
                    // 섞인 박스는 무조건 한 번에 조커로 옮긴다
                    moves++;
                } else {
                    int c = onlyColor[box];
                    if (used[c]) moves++;   // 같은 색 대표 박스가 이미 있으면 이 박스는 비워야 함
                    else used[c] = true;    // 이 박스를 대표로 유지
                }
            }

            ans = Math.min(ans, moves);
        }

        System.out.println(ans);
    }
}
