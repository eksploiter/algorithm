import java.io.*;
import java.util.*;

public class Main {
    static final long INF = (long) 1e18;

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ' && c != -1);
            long sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        int nextInt() throws IOException { return (int) nextLong(); }
    }

    static long solveCase(int N, int W, int[] top, int[] bot, boolean connectTop, boolean connectBot) {
        if (N == 1) {
            // 원형 연결 의미 없음
            return (top[0] + bot[0] <= W) ? 1 : 2;
        }

        // 연결 가능성 체크
        if (connectTop && top[0] + top[N - 1] > W) return INF;
        if (connectBot && bot[0] + bot[N - 1] > W) return INF;

        boolean[] preTop = new boolean[N];
        boolean[] preBot = new boolean[N];

        long base = 0;
        if (connectTop) {
            preTop[0] = preTop[N - 1] = true;
            base += 1; // (위 1-N) 한 소대
        }
        if (connectBot) {
            preBot[0] = preBot[N - 1] = true;
            base += 1; // (아래 1-N) 한 소대
        }

        // dp[i][mask] : i번째 열까지 처리(0..i-1 완료), i열에서 왼쪽(i-1)과 가로로 묶여 미리 덮인 상태 mask
        // mask bit1: top covered from left, bit2: bot covered from left
        long[][] dp = new long[N + 1][4];
        for (int i = 0; i <= N; i++) Arrays.fill(dp[i], INF);
        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            for (int mask = 0; mask < 4; mask++) {
                long curCost = dp[i][mask];
                if (curCost >= INF) continue;

                boolean topCovered = preTop[i] || ((mask & 1) != 0);
                boolean botCovered = preBot[i] || ((mask & 2) != 0);

                // hTop/hBot: i열의 해당 칸을 i+1열과 가로로 묶어서 덮을지
                for (int hTop = 0; hTop <= 1; hTop++) {
                    for (int hBot = 0; hBot <= 1; hBot++) {

                        // 마지막 열에서는 오른쪽으로 가로 연결 불가
                        if (i == N - 1 && (hTop == 1 || hBot == 1)) continue;

                        // 이미 덮인 칸이면 가로 시작 불가
                        if (hTop == 1 && topCovered) continue;
                        if (hBot == 1 && botCovered) continue;

                        int nextMask = 0;
                        long add = 0;

                        // 위쪽 가로 연결 검사
                        if (hTop == 1) {
                            if (preTop[i + 1]) continue; // 다음 칸이 외부(원형)로 이미 덮인 상태면 가로 불가
                            if (top[i] + top[i + 1] > W) continue;
                            nextMask |= 1;
                            add += 1;
                        }

                        // 아래쪽 가로 연결 검사
                        if (hBot == 1) {
                            if (preBot[i + 1]) continue;
                            if (bot[i] + bot[i + 1] > W) continue;
                            nextMask |= 2;
                            add += 1;
                        }

                        // 현재 열에서 아직 안 덮인 칸(가로로 덮지도 않은 칸)을 처리
                        boolean remTop = !topCovered && (hTop == 0);
                        boolean remBot = !botCovered && (hBot == 0);

                        long coverRem = 0;
                        if (remTop && remBot) {
                            // 세로로 한 번에 덮기 가능?
                            if (!preTop[i] && !preBot[i] && top[i] + bot[i] <= W) coverRem = 1;
                            else coverRem = 2;
                        } else if (remTop || remBot) {
                            coverRem = 1;
                        }

                        dp[i + 1][nextMask] = Math.min(dp[i + 1][nextMask], curCost + add + coverRem);
                    }
                }
            }
        }

        return base + dp[N][0];
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = fs.nextInt();
        while (T-- > 0) {
            int N = fs.nextInt();
            int W = fs.nextInt();

            int[] top = new int[N];
            int[] bot = new int[N];

            for (int i = 0; i < N; i++) top[i] = fs.nextInt();
            for (int i = 0; i < N; i++) bot[i] = fs.nextInt();

            long ans = INF;
            ans = Math.min(ans, solveCase(N, W, top, bot, false, false));
            ans = Math.min(ans, solveCase(N, W, top, bot, true,  false));
            ans = Math.min(ans, solveCase(N, W, top, bot, false, true));
            ans = Math.min(ans, solveCase(N, W, top, bot, true,  true));

            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
