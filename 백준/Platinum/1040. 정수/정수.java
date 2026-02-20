import java.io.*;
import java.util.*;

public class Main {

    static String base;      // 길이가 L일 때 하한(같은 길이면 N, 더 길면 000..)
    static int L, K;
    static byte[][][] memo;  // -1: unknown, 0: false, 1: true

    static int bitCount(int mask) {
        return Integer.bitCount(mask);
    }

    static boolean possible(int pos, int mask, int greater) {
        int used = bitCount(mask);

        // 너무 많이 쓴 경우
        if (used > K) return false;

        // 남은 자리로 K개를 채울 수 없는 경우 가지치기
        int remaining = L - pos;
        int maxAdd = Math.min(10 - used, remaining);
        if (used + maxAdd < K) return false;

        if (pos == L) {
            return used == K;
        }

        byte m = memo[pos][mask][greater];
        if (m != -1) return m == 1;

        int lower = 0;
        if (greater == 0) lower = base.charAt(pos) - '0';

        // leading zero 금지 (L>1일 때 첫 자리)
        if (pos == 0 && L > 1) lower = Math.max(lower, 1);

        boolean ok = false;
        for (int d = lower; d <= 9; d++) {
            int ngreater = greater;
            if (greater == 0) {
                int bd = base.charAt(pos) - '0';
                if (d > bd) ngreater = 1;
            }
            int nmask = mask | (1 << d);
            if (possible(pos + 1, nmask, ngreater)) {
                ok = true;
                break;
            }
        }

        memo[pos][mask][greater] = (byte) (ok ? 1 : 0);
        return ok;
    }

    static String buildAnswer() {
        StringBuilder sb = new StringBuilder();
        int pos = 0, mask = 0, greater = 0;

        while (pos < L) {
            int lower = 0;
            if (greater == 0) lower = base.charAt(pos) - '0';
            if (pos == 0 && L > 1) lower = Math.max(lower, 1);

            for (int d = lower; d <= 9; d++) {
                int ngreater = greater;
                if (greater == 0) {
                    int bd = base.charAt(pos) - '0';
                    if (d > bd) ngreater = 1;
                }
                int nmask = mask | (1 << d);
                if (possible(pos + 1, nmask, ngreater)) {
                    sb.append((char) ('0' + d));
                    mask = nmask;
                    greater = ngreater;
                    pos++;
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        K = Integer.parseInt(st.nextToken());

        int lenN = N.length();

        for (int len = lenN; len <= 19; len++) {
            L = len;

            if (K > Math.min(10, L)) continue;

            if (L == lenN) base = N;
            else {
                char[] zeros = new char[L];
                Arrays.fill(zeros, '0');
                base = new String(zeros);
            }

            memo = new byte[L + 1][1 << 10][2];
            for (int i = 0; i <= L; i++) {
                for (int m = 0; m < (1 << 10); m++) {
                    Arrays.fill(memo[i][m], (byte) -1);
                }
            }

            if (possible(0, 0, 0)) {
                System.out.println(buildAnswer());
                return;
            }
        }

        System.out.println(-1);
    }
}