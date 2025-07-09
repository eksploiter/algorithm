import java.io.*;

public class Main {
    static int[][] dp;
    static String s;

    static int solveDP(String str) {
        int n = str.length();
        dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int cost = (str.charAt(i) == str.charAt(j)) ? 0 : 1;
                dp[i][j] = Math.min(
                    Math.min(dp[i+1][j] + 1, dp[i][j-1] + 1),
                    dp[i+1][j-1] + cost
                );
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().trim();
        int ans = solveDP(s);

        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                StringBuilder sb = new StringBuilder(s);
                char c1 = sb.charAt(i), c2 = sb.charAt(j);
                sb.setCharAt(i, c2);
                sb.setCharAt(j, c1);
                ans = Math.min(ans, solveDP(sb.toString()) + 1);
            }
        }
        System.out.println(ans);
    }
}
