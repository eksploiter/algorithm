import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    static int n, k;
    static long[] memo;
    static int KMAX; // k <= 9 only

    static int idx(int pos, int left, int lastDigit, int diff) {
        // sizes: (n+1) * (k+1) * 10 * 11
        return (((pos * (KMAX + 1) + left) * 10 + lastDigit) * 11 + diff);
    }

    static long dp(int pos, int left, int last, int diff) {
        if (left < 0) return 0;
        if (pos == n) return (left == 0) ? 1 : 0;

        int id = idx(pos, left, last, diff);
        long cached = memo[id];
        if (cached != -1) return cached;

        long ret = 0;

        if (diff < 10) {
            int expected = last + diff;
            for (int nd = last; nd <= 9; nd++) {
                if (nd == expected) {
                    ret += dp(pos + 1, left, nd, diff);
                } else {
                    ret += dp(pos + 1, left - 1, nd, 10);
                }
                if (ret >= MOD) ret %= MOD;
            }
        } else {
            for (int nd = last; nd <= 9; nd++) {
                ret += dp(pos + 1, left, nd, nd - last);
                if (ret >= MOD) ret %= MOD;
            }
        }

        ret %= MOD;
        memo[id] = ret;
        return ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (k > 9) {
            System.out.println(0);
            return;
        }
        KMAX = k;

        int size = (n + 1) * (KMAX + 1) * 10 * 11;
        memo = new long[size];
        Arrays.fill(memo, -1);

        long ans = 0;
        for (int first = 1; first <= 9; first++) {
            ans += dp(1, k - 1, first, 10);
            ans %= MOD;
        }

        System.out.println(ans);
    }
}