import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] x, y;
    static long totalX, totalY;
    static double best;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine().trim());
            x = new long[N];
            y = new long[N];
            totalX = 0;
            totalY = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                x[i] = Long.parseLong(st.nextToken());
                y[i] = Long.parseLong(st.nextToken());
                totalX += x[i];
                totalY += y[i];
            }

            best = Double.MAX_VALUE;

            // 대칭 제거: 0번은 항상 선택(+쪽)에 넣고 시작
            dfs(1, 1, x[0], y[0]);

            sb.append(String.format(Locale.US, "%.12f\n", best));
        }

        System.out.print(sb);
    }

    // idx: 다음으로 볼 인덱스
    // picked: 현재까지 선택된(+쪽) 점 개수
    // sumX, sumY: 선택된(+쪽) 점들의 좌표 합
    static void dfs(int idx, int picked, long sumX, long sumY) {
        int need = N / 2;

        if (picked == need) {
            // 결과 벡터 = (sum(+) - sum(-)) = 2*sum(+) - total
            long rx = 2L * sumX - totalX;
            long ry = 2L * sumY - totalY;

            double len = Math.sqrt((double) rx * rx + (double) ry * ry);
            if (len < best) best = len;
            return;
        }

        // 더 뽑을 수 없는 경우 가지치기
        if (idx == N) return;
        if (picked + (N - idx) < need) return;

        // idx 선택
        dfs(idx + 1, picked + 1, sumX + x[idx], sumY + y[idx]);

        // idx 미선택
        dfs(idx + 1, picked, sumX, sumY);
    }
}
