import java.io.*;
import java.util.*;

public class Main {
    // 문제에서 주어진 세그먼트 개수 (0~9)
    // 0:6, 1:2, 2:5, 3:5, 4:4, 5:5, 6:6, 7:3, 8:7, 9:5
    static final int[] SEG = {6, 2, 5, 5, 4, 5, 6, 3, 7, 5};

    static int N;
    static int[] lowerDigits;         // 하한(>=) 숫자의 각 자리
    static byte[][][] memo;           // -1 unknown, 0 false, 1 true
    static int TARGET;

    static long pow10(int n) {
        long v = 1;
        for (int i = 0; i < n; i++) v *= 10L;
        return v;
    }

    static String addOneKeepLen(String s) {
        char[] a = s.toCharArray();
        int i = a.length - 1;
        while (i >= 0 && a[i] == '9') {
            a[i] = '0';
            i--;
        }
        if (i < 0) return null; // overflow (999..9 + 1)
        a[i] = (char)(a[i] + 1);
        return new String(a);
    }

    static int segSum(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) sum += SEG[s.charAt(i) - '0'];
        return sum;
    }

    static boolean possible(int pos, int rem, int tight) {
        if (rem < 0) return false;

        if (pos == N) return rem == 0;

        // 남은 자리로 rem을 만들 수 있는지 간단 가지치기
        int left = N - pos;
        int minPerDigit = 2;   // digit 1이 2개
        int maxPerDigit = 7;   // digit 8이 7개
        if (rem < left * minPerDigit) return false;
        if (rem > left * maxPerDigit) return false;

        byte v = memo[pos][rem][tight];
        if (v != -1) return v == 1;

        int start = (tight == 1) ? lowerDigits[pos] : 0;
        boolean ok = false;

        for (int d = start; d <= 9; d++) {
            int ntight = (tight == 1 && d == lowerDigits[pos]) ? 1 : 0;
            if (possible(pos + 1, rem - SEG[d], ntight)) {
                ok = true;
                break;
            }
        }
        memo[pos][rem][tight] = (byte)(ok ? 1 : 0);
        return ok;
    }

    static String buildMin() {
        StringBuilder sb = new StringBuilder();
        int rem = TARGET;
        int tight = 1;

        for (int pos = 0; pos < N; pos++) {
            int start = (tight == 1) ? lowerDigits[pos] : 0;
            for (int d = start; d <= 9; d++) {
                int ntight = (tight == 1 && d == lowerDigits[pos]) ? 1 : 0;
                if (possible(pos + 1, rem - SEG[d], ntight)) {
                    sb.append((char)('0' + d));
                    rem -= SEG[d];
                    tight = ntight;
                    break;
                }
            }
        }
        return sb.toString();
    }

    // 길이 N 고정, lower 이상이면서 세그먼트 합이 TARGET인 최소 수(문자열). 없으면 null
    static String findMinGE(String lower) {
        lowerDigits = new int[N];
        for (int i = 0; i < N; i++) lowerDigits[i] = lower.charAt(i) - '0';

        memo = new byte[N + 1][TARGET + 1][2];
        for (int i = 0; i <= N; i++) {
            for (int r = 0; r <= TARGET; r++) {
                Arrays.fill(memo[i][r], (byte)-1);
            }
        }

        if (!possible(0, TARGET, 1)) return null;
        return buildMin();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Xstr = br.readLine().trim();
        N = Xstr.length();

        TARGET = segSum(Xstr);
        long X = Long.parseLong(Xstr);   // N<=15 => long 안전
        long MOD = pow10(N);

        // 1) X+1 이상에서 찾기
        String lower1 = addOneKeepLen(Xstr);
        if (lower1 != null) {
            String Ystr = findMinGE(lower1);
            if (Ystr != null) {
                long Y = Long.parseLong(Ystr);
                System.out.println(Y - X);
                return;
            }
        }

        // 2) wrap: 000..0 이상에서 최소를 찾기
        char[] zeros = new char[N];
        Arrays.fill(zeros, '0');
        String Zstr = findMinGE(new String(zeros));

        long Z = Long.parseLong(Zstr); // 반드시 존재 (최소한 X 본인)
        long ans = (MOD - X) + Z;      // Z==X면 MOD(한 바퀴)
        System.out.println(ans);
    }
}