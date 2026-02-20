import java.io.*;
import java.util.*;

public class Main {

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

        int nextInt() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return Integer.MIN_VALUE;
            } while (c <= ' ');

            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            do {
                c = readByte();
                if (c == -1) return null;
            } while (c <= ' ');
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }

    static List<Integer> validMasks(int m) {
        List<Integer> list = new ArrayList<>();
        int S = 1 << m;
        for (int mask = 0; mask < S; mask++) {
            if ((mask & (mask << 1)) != 0) continue; // 좌우 인접 금지
            list.add(mask);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            int[] avail = new int[n]; // 앉을 수 있는 자리면 1
            for (int i = 0; i < n; i++) {
                String row = fs.next();
                int mask = 0;
                for (int j = 0; j < m; j++) {
                    if (row.charAt(j) == '.') {
                        mask |= (1 << j);
                    }
                }
                avail[i] = mask;
            }

            List<Integer> allValid = validMasks(m);

            // 각 행마다 "그 행에서 가능한 valid mask"만 골라두기
            List<int[]> rowMasks = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int mask : allValid) {
                    if ((mask & ~avail[i]) == 0) tmp.add(mask); // x 자리에는 못 앉음
                }
                int[] arr = new int[tmp.size()];
                for (int k = 0; k < tmp.size(); k++) arr[k] = tmp.get(k);
                rowMasks.add(arr);
            }

            int S = 1 << m;
            int NEG = -1_000_000;

            int[] dpPrev = new int[S];
            int[] dpCur = new int[S];
            Arrays.fill(dpPrev, NEG);
            dpPrev[0] = 0;

            int ans = 0;

            for (int r = 0; r < n; r++) {
                Arrays.fill(dpCur, NEG);
                int[] candidates = rowMasks.get(r);

                for (int prev = 0; prev < S; prev++) {
                    if (dpPrev[prev] == NEG) continue;

                    for (int mask : candidates) {
                        if ((mask & (prev << 1)) != 0) continue;
                        if ((mask & (prev >> 1)) != 0) continue;

                        int val = dpPrev[prev] + Integer.bitCount(mask);
                        if (val > dpCur[mask]) dpCur[mask] = val;
                        if (val > ans) ans = val;
                    }
                }

                int[] tmp = dpPrev; dpPrev = dpCur; dpCur = tmp;
            }

            out.append(ans);
            if (tc + 1 < T) out.append('\n');
        }

        System.out.print(out);
    }
}