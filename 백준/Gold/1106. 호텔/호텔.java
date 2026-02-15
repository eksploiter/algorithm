import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] gain = new int[N];
        int maxGain = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            gain[i] = Integer.parseInt(st.nextToken());
            maxGain = Math.max(maxGain, gain[i]);
        }

        int MAX = C + maxGain; // C 이상을 만들기 위한 최소한의 여유
        int INF = 1_000_000_000;

        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // 무한 배낭: i를 증가시키며 갱신
        for (int i = 0; i <= MAX; i++) {
            if (dp[i] == INF) continue;
            for (int j = 0; j < N; j++) {
                int ni = i + gain[j];
                if (ni > MAX) continue;
                dp[ni] = Math.min(dp[ni], dp[i] + cost[j]);
            }
        }

        int ans = INF;
        for (int i = C; i <= MAX; i++) ans = Math.min(ans, dp[i]);

        System.out.println(ans);
    }
}
