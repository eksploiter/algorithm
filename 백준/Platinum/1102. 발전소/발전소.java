import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String state = br.readLine().trim(); // Y/N
        int P = Integer.parseInt(br.readLine().trim());

        if (P == 0) {
            System.out.println(0);
            return;
        }

        int start = 0;
        int onCount = 0;
        for (int i = 0; i < N; i++) {
            if (state.charAt(i) == 'Y') {
                start |= (1 << i);
                onCount++;
            }
        }

        if (onCount == 0) { // 켜진 발전소가 하나도 없으면 어떤 것도 켤 수 없음
            System.out.println(-1);
            return;
        }

        int S = 1 << N;
        int[] dp = new int[S];
        Arrays.fill(dp, INF);
        dp[start] = 0;

        int answer = INF;

        for (int mask = 0; mask < S; mask++) {
            if (dp[mask] == INF) continue;

            int cnt = Integer.bitCount(mask);
            if (cnt >= P) {
                answer = Math.min(answer, dp[mask]);
                continue;
            }

            // 꺼진 발전소 j를 하나 켠다
            for (int j = 0; j < N; j++) {
                if ((mask & (1 << j)) != 0) continue; // 이미 켜짐

                int add = INF;
                // 현재 켜진 i 중 가장 싸게 j를 켤 수 있는 비용
                for (int i = 0; i < N; i++) {
                    if ((mask & (1 << i)) == 0) continue;
                    add = Math.min(add, cost[i][j]);
                }

                int next = mask | (1 << j);
                dp[next] = Math.min(dp[next], dp[mask] + add);
            }
        }

        System.out.println(answer == INF ? -1 : answer);
    }
}