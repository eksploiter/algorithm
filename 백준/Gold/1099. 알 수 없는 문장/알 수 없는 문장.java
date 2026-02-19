import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().trim();
        int L = s.length();

        int N = Integer.parseInt(br.readLine().trim());
        String[] words = new String[N];
        int[] wLen = new int[N];
        int[][] wCnt = new int[N][26];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().trim();
            wLen[i] = words[i].length();
            for (int k = 0; k < wLen[i]; k++) {
                wCnt[i][words[i].charAt(k) - 'a']++;
            }
        }

        int[][] pref = new int[L + 1][26];
        for (int i = 0; i < L; i++) {
            System.arraycopy(pref[i], 0, pref[i + 1], 0, 26);
            pref[i + 1][s.charAt(i) - 'a']++;
        }

        int[] dp = new int[L + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < L; i++) {
            if (dp[i] == INF) continue;

            for (int wi = 0; wi < N; wi++) {
                int m = wLen[wi];
                int end = i + m;
                if (end > L) continue;

                boolean ok = true;
                for (int c = 0; c < 26; c++) {
                    int subCnt = pref[end][c] - pref[i][c];
                    if (subCnt != wCnt[wi][c]) {
                        ok = false;
                        break;
                    }
                }
                if (!ok) continue;
                int cost = 0;
                String w = words[wi];
                for (int k = 0; k < m; k++) {
                    if (s.charAt(i + k) != w.charAt(k)) cost++;
                }

                dp[end] = Math.min(dp[end], dp[i] + cost);
            }
        }

        System.out.println(dp[L] == INF ? -1 : dp[L]);
    }
}
