import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[][] price = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                price[i][j] = s.charAt(j) - '0';
            }
        }

        int S = 1 << N;
        final int INF = 10; // 가격은 0~9, 10이면 도달 불가로 쓰기 좋음

        int[][] dp = new int[S][N];
        for (int st = 0; st < S; st++) Arrays.fill(dp[st], INF);

        dp[1][0] = 0; // 0번이 그림 보유 시작, 마지막 거래 가격 0으로 간주

        int ans = 1;

        for (int st = 0; st < S; st++) {
            int cnt = Integer.bitCount(st);
            for (int i = 0; i < N; i++) {
                int last = dp[st][i];
                if (last == INF) continue;

                ans = Math.max(ans, cnt);

                for (int j = 0; j < N; j++) {
                    if ((st & (1 << j)) != 0) continue; // 이미 소유했던 사람은 제외

                    int p = price[i][j];
                    if (p < last) continue; // 가격이 내려가면 불가

                    int next = st | (1 << j);
                    if (dp[next][j] > p) dp[next][j] = p;
                }
            }
        }

        System.out.println(ans);
    }
}