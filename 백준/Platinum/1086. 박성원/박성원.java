import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String[] arr;
    static int[] len;
    static int[] mod;
    static int[] pow10mod;

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    static long factorial(int n) {
        long res = 1L;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        arr = new String[N];
        len = new int[N];

        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().trim();
            len[i] = arr[i].length();
            maxLen = Math.max(maxLen, len[i]);
        }

        K = Integer.parseInt(br.readLine().trim());

        // 10^L % K 미리 계산
        pow10mod = new int[maxLen + 1];
        pow10mod[0] = 1 % K;
        for (int i = 1; i <= maxLen; i++) {
            pow10mod[i] = (pow10mod[i - 1] * 10) % K;
        }

        mod = new int[N];
        for (int i = 0; i < N; i++) {
            int r = 0;
            for (int c = 0; c < arr[i].length(); c++) {
                r = (r * 10 + (arr[i].charAt(c) - '0')) % K;
            }
            mod[i] = r;
        }

        int fullMask = (1 << N) - 1;
        long[][] dp = new long[1 << N][K];
        dp[0][0] = 1;

        for (int mask = 0; mask <= fullMask; mask++) {
            for (int r = 0; r < K; r++) {
                long cur = dp[mask][r];
                if (cur == 0) continue;

                for (int i = 0; i < N; i++) {
                    if ((mask & (1 << i)) != 0) continue;

                    int nmask = mask | (1 << i);
                    int nr = (int) (((long) r * pow10mod[len[i]] + mod[i]) % K);
                    dp[nmask][nr] += cur;
                }
            }
        }

        long success = dp[fullMask][0];
        long total = factorial(N);

        if (success == 0) {
            System.out.println("0/1");
            return;
        }

        long g = gcd(success, total);
        System.out.println((success / g) + "/" + (total / g));
    }
}