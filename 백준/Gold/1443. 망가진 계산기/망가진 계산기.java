import java.io.*;
import java.util.*;

public class Main {

    static int D, P;
    static int ans = -1;
    static int[] pow10 = new int[10]; // pow10[i] = 10^i
    static HashSet<Integer>[] visited; // visited[cnt]에 value 저장

    static int digits(int x) {
        // D <= 8 이라 pow10으로 빠르게 자릿수 판정
        // x >= 1
        for (int i = 1; i <= 9; i++) {
            if (x < pow10[i]) return i;
        }
        return 10;
    }

    static void dfs(int cnt, int start, int value) {
        if (digits(value) > D) return;

        // 같은 (cnt, value) 상태는 다시 볼 필요 없음
        if (visited[cnt].contains(value)) return;
        visited[cnt].add(value);

        if (cnt == P) {
            if (value > ans) ans = value;
            return;
        }

        for (int m = start; m <= 9; m++) {
            long next = (long) value * m;
            // D <= 8이므로 value는 최대 99,999,999 정도에서 관리되지만 안전하게 long
            if (next >= pow10[D + 1]) continue; // 자릿수 초과 확실한 경우 빠른 컷
            dfs(cnt + 1, m, (int) next);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        D = fs.nextInt();
        P = fs.nextInt();

        pow10[0] = 1;
        for (int i = 1; i < pow10.length; i++) pow10[i] = pow10[i - 1] * 10;

        visited = new HashSet[P + 1];
        for (int i = 0; i <= P; i++) visited[i] = new HashSet<>();

        dfs(0, 2, 1);

        System.out.print(ans);
    }

    // 빠른 입력
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do { c = read(); } while (c <= ' ');

            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
