import java.io.*;
import java.util.*;

public class Main {

    static long valueAt(int r, int c) {
        int n = Math.max(Math.abs(r), Math.abs(c));   // 레이어
        long m = (long)(2L * n + 1) * (2L * n + 1);   // (n, n)에 있는 값 = (2n+1)^2

        if (n == 0) return 1;

        // (n,n)에서 시작해 반시계 방향으로 값이 감소하는 형태
        if (r == n) { // 아래쪽 변: (n,n) -> (n,-n)
            return m - (n - c);
        } else if (c == -n) { // 왼쪽 변: (n,-n) -> (-n,-n)
            return (m - 2L * n) - (n - r);
        } else if (r == -n) { // 위쪽 변: (-n,-n) -> (-n,n)
            return (m - 4L * n) - (c + n);
        } else { // 오른쪽 변: (-n,n) -> (n,n) (단, r != n)
            return (m - 6L * n) - (r + n);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int R = r2 - r1 + 1;
        int C = c2 - c1 + 1;

        long[][] arr = new long[R][C];
        long maxVal = 0;

        for (int i = 0; i < R; i++) {
            int r = r1 + i;
            for (int j = 0; j < C; j++) {
                int c = c1 + j;
                long v = valueAt(r, c);
                arr[i][j] = v;
                if (v > maxVal) maxVal = v;
            }
        }

        int width = Long.toString(maxVal).length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                String s = Long.toString(arr[i][j]);
                for (int k = s.length(); k < width; k++) sb.append(' ');
                sb.append(s);
                if (j + 1 < C) sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
