import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    static int R, C;
    static char[][] grid; // 1-indexed
    static String S;

    static long mod(long x) {
        x %= MOD;
        if (x < 0) x += MOD;
        return x;
    }

    // ps는 1-indexed prefix sum: ps[i][j] = sum(1..i, 1..j)
    static long rangeSum(long[][] ps, int r1, int c1, int r2, int c2) {
        if (r1 > r2 || c1 > c2) return 0;
        if (r2 < 1 || c2 < 1 || r1 > R || c1 > C) return 0;

        r1 = Math.max(r1, 1);
        c1 = Math.max(c1, 1);
        r2 = Math.min(r2, R);
        c2 = Math.min(c2, C);

        long res = ps[r2][c2] - ps[r1 - 1][c2] - ps[r2][c1 - 1] + ps[r1 - 1][c1 - 1];
        return mod(res);
    }

    static long calcWaysTo(long[][] prevPS, int i, int j) {
        long total = prevPS[R][C];

        long bandRow = rangeSum(prevPS, i - 1, 1, i + 1, C);          // |dx|<=1
        long bandCol = rangeSum(prevPS, 1, j - 1, R, j + 1);          // |dy|<=1
        long inter3x3 = rangeSum(prevPS, i - 1, j - 1, i + 1, j + 1); // 중복 보정

        long ans = total - bandRow - bandCol + inter3x3;

        // (|dx|,|dy|)=(2,2) 인 4칸 제외
        ans -= rangeSum(prevPS, i - 2, j - 2, i - 2, j - 2);
        ans -= rangeSum(prevPS, i - 2, j + 2, i - 2, j + 2);
        ans -= rangeSum(prevPS, i + 2, j - 2, i + 2, j - 2);
        ans -= rangeSum(prevPS, i + 2, j + 2, i + 2, j + 2);

        return mod(ans);
    }

    static void buildPrefixFromValues(long[][] val, long[][] ps) {
        for (int i = 0; i <= R; i++) Arrays.fill(ps[i], 0);
        for (int i = 1; i <= R; i++) {
            long rowAcc = 0;
            for (int j = 1; j <= C; j++) {
                rowAcc += val[i][j];
                rowAcc %= MOD;
                ps[i][j] = (ps[i - 1][j] + rowAcc) % MOD;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); // 사용 가능한 알파벳 개수 (A..)

        S = br.readLine().trim();
        for (int k = 0; k < S.length(); k++) {
            int idx = S.charAt(k) - 'A' + 1;
            if (idx > L) { // 격자에 절대 없을 알파벳이면 불가능
                System.out.println(0);
                return;
            }
        }

        grid = new char[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String row = br.readLine().trim();
            for (int j = 1; j <= C; j++) grid[i][j] = row.charAt(j - 1);
        }

        // dpPrevPS: 이전 단계 dp의 prefix sum
        long[][] dpPrevPS = new long[R + 1][C + 1];
        long[][] dpNextVal = new long[R + 1][C + 1];
        long[][] dpNextPS = new long[R + 1][C + 1];

        // 초기: S[0]인 칸은 1, 아니면 0
        char first = S.charAt(0);
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                dpNextVal[i][j] = (grid[i][j] == first) ? 1 : 0;
            }
        }
        buildPrefixFromValues(dpNextVal, dpPrevPS);

        // 다음 문자들 처리
        for (int k = 1; k < S.length(); k++) {
            char ch = S.charAt(k);

            for (int i = 0; i <= R; i++) Arrays.fill(dpNextVal[i], 0);

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (grid[i][j] != ch) continue;
                    dpNextVal[i][j] = calcWaysTo(dpPrevPS, i, j);
                }
            }

            buildPrefixFromValues(dpNextVal, dpNextPS);

            // swap
            long[][] tmp = dpPrevPS;
            dpPrevPS = dpNextPS;
            dpNextPS = tmp;
        }

        // 마지막 단계의 전체 합
        System.out.println(dpPrevPS[R][C] % MOD);
    }
}