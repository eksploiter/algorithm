import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            sum += a[i];
        }

        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int h : a) {
            int[] next = dp.clone(); // "안 쓰기"는 그대로 복사

            for (int d = 0; d <= sum; d++) {
                if (dp[d] < 0) continue;

                int H = dp[d];      // 더 높은 탑 높이
                int L = H - d;      // 더 낮은 탑 높이

                // 1) 높은 쪽에 올림
                int d1 = d + h;
                if (d1 <= sum) {
                    next[d1] = Math.max(next[d1], H + h);
                }

                // 2) 낮은 쪽에 올림
                int newLow = L + h;
                int newHigh = Math.max(H, newLow);
                int d2 = Math.abs(d - h);
                next[d2] = Math.max(next[d2], newHigh);
            }

            dp = next;
        }

        System.out.println(dp[0] > 0 ? dp[0] : -1);
    }
}