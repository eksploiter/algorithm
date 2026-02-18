import java.io.*;
import java.util.*;

public class Main {
    static boolean better(String a, String b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.length() != b.length()) return a.length() > b.length();
        return a.compareTo(b) > 0; // 길이 같으면 사전순(=숫자 크기) 비교
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine().trim());

        String[] dp = new String[M + 1];
        dp[0] = ""; // 아직 숫자 안 만든 상태(베이스)

        for (int cost = 0; cost <= M; cost++) {
            if (dp[cost] == null) continue;

            // "0"으로 시작한 수는 더 붙이면 leading zero가 되므로 확장 금지
            if (dp[cost].equals("0")) continue;

            for (int d = 0; d < N; d++) {
                int nc = cost + P[d];
                if (nc > M) continue;

                // 첫 글자가 0인 경우는 "0" 단독만 허용
                if (dp[cost].isEmpty() && d == 0) {
                    String cand = "0";
                    if (better(cand, dp[nc])) dp[nc] = cand;
                } else {
                    String cand = dp[cost] + d;
                    if (better(cand, dp[nc])) dp[nc] = cand;
                }
            }
        }

        String ans = null;
        for (int c = 1; c <= M; c++) { // 적어도 하나는 살 수 있음
            if (dp[c] != null && !dp[c].isEmpty()) {
                if (better(dp[c], ans)) ans = dp[c];
            }
        }

        System.out.println(ans);
    }
}
