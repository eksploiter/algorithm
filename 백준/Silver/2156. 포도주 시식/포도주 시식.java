import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[n + 1][3];

        // 초기화
        for (int i = 0; i <= n; i++) {
            for (int cnt = 0; cnt < 3; cnt++) {
                dp[i][cnt] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;

        // DP 진행
        for (int i = 0; i < n; i++) {
            for(int cnt = 0; cnt < 3; cnt++) {
                if (dp[i][cnt] == Integer.MIN_VALUE) continue;

                dp[i + 1][0] = Math.max(dp[i + 1][0], dp[i][cnt]);

                if (cnt < 2) {
                    dp[i + 1][cnt + 1] = Math.max(dp[i + 1][cnt + 1], dp[i][cnt] + arr[i]);
                }
            }
        }

        int result = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        System.out.println(result);
    }
}
