import java.io.*;
import java.util.*;

public class Main {
    // 빠른 입력
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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
            do c = readByte(); while (c <= ' ' && c != -1);
            long sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        long N = fs.nextLong();
        long R = N / 2;              // 반지름
        long RR = R * R;             // R^2

        long xPrev = 0;              // 이전 행에서의 x 경계
        long x = 0;                  // 현재 행에서 최대 x (단조 증가)
        long quarter = 0;            // 1사분면(우상단 1/4)에서의 개수

        for (long y = R - 1; y >= 0; y--) {
            // (x+1, y)가 원 안(또는 원 위)일 때까지 x 증가
            while ((x + 1) * (x + 1) + y * y <= RR) x++;

            // 경계가 정확히 격자점 (x, y)에 지나가는 경우 보정
            if (x * x + y * y == RR) quarter += (x - xPrev);
            else quarter += (x - xPrev + 1);

            xPrev = x;
        }

        long ans = quarter * 4; // 4분면 대칭
        System.out.println(ans);
    }
}
