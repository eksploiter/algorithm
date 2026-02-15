import java.io.*;
import java.util.*;

public class Main {
    static final int LIMIT = 1791;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        if (N <= LIMIT) {
            System.out.println(solveSmallDP(N));
        } else {
            System.out.println(solveUpTo4(N));
        }
    }

    // N <= 1791: 일반 DP(동전 최소 개수)
    static int solveSmallDP(int N) {
        ArrayList<Integer> hex = genHex(N);

        int INF = 1_000_000_000;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int best = INF;
            for (int h : hex) {
                if (h > i) break;
                int cand = dp[i - h] + 1;
                if (cand < best) best = cand;
            }
            dp[i] = best;
        }
        return dp[N];
    }

    // N > 1791: 답은 1~4 중 하나. (1개/2개/3개/4개 체크)
    static int solveUpTo4(int N) {
        ArrayList<Integer> hex = genHex(N);
        boolean[] isHex = new boolean[N + 1];
        for (int h : hex) isHex[h] = true;

        if (isHex[N]) return 1;

        // can2[s] = 육각수 2개 합으로 s 만들 수 있나
        boolean[] can2 = new boolean[N + 1];
        int m = hex.size();
        for (int i = 0; i < m; i++) {
            int a = hex.get(i);
            for (int j = i; j < m; j++) {
                int b = hex.get(j);
                int s = a + b;
                if (s > N) break;
                can2[s] = true;
            }
        }

        if (can2[N]) return 2;

        // 3개: h + (2개합)
        for (int h : hex) {
            if (h > N) break;
            if (can2[N - h]) return 3;
        }

        // 4개: (2개합) + (2개합)
        for (int s = 1; s <= N; s++) {
            if (can2[s] && can2[N - s]) return 4;
        }

        return 4;
    }

    static ArrayList<Integer> genHex(int maxN) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = 1; ; k++) {
            long h = (long) k * (2L * k - 1L); // k(2k-1)
            if (h > maxN) break;
            list.add((int) h);
        }
        return list;
    }
}
