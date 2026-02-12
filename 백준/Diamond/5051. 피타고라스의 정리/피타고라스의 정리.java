import java.io.*;
import java.util.*;

public class Main {

    private static final class FastScanner {
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
            if (c == -1) return Long.MIN_VALUE;
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

    private static void fft(double[] re, double[] im, boolean invert) {
        int n = re.length;

        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >>> 1;
            for (; (j & bit) != 0; bit >>>= 1) j ^= bit;
            j ^= bit;
            if (i < j) {
                double tr = re[i]; re[i] = re[j]; re[j] = tr;
                double ti = im[i]; im[i] = im[j]; im[j] = ti;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            double ang = 2 * Math.PI / len * (invert ? -1 : 1);
            double wlenRe = Math.cos(ang);
            double wlenIm = Math.sin(ang);

            for (int i = 0; i < n; i += len) {
                double wRe = 1.0, wIm = 0.0;
                int half = len >>> 1;
                for (int j = 0; j < half; j++) {
                    int u = i + j;
                    int v = i + j + half;

                    double uRe = re[u], uIm = im[u];
                    double vRe = re[v] * wRe - im[v] * wIm;
                    double vIm = re[v] * wIm + im[v] * wRe;

                    re[u] = uRe + vRe;
                    im[u] = uIm + vIm;
                    re[v] = uRe - vRe;
                    im[v] = uIm - vIm;

                    double nextWRe = wRe * wlenRe - wIm * wlenIm;
                    double nextWIm = wRe * wlenIm + wIm * wlenRe;
                    wRe = nextWRe;
                    wIm = nextWIm;
                }
            }
        }

        if (invert) {
            for (int i = 0; i < n; i++) {
                re[i] /= n;
                im[i] /= n;
            }
        }
    }

    private static long[] convolutionLong(long[] a, long[] b) {
        int n1 = a.length, n2 = b.length;
        int need = n1 + n2 - 1;
        int n = 1;
        while (n < need) n <<= 1;

        double[] faRe = new double[n];
        double[] faIm = new double[n];
        double[] fbRe = new double[n];
        double[] fbIm = new double[n];

        for (int i = 0; i < n1; i++) faRe[i] = a[i];
        for (int i = 0; i < n2; i++) fbRe[i] = b[i];

        fft(faRe, faIm, false);
        fft(fbRe, fbIm, false);

        for (int i = 0; i < n; i++) {
            double re = faRe[i] * fbRe[i] - faIm[i] * fbIm[i];
            double im = faRe[i] * fbIm[i] + faIm[i] * fbRe[i];
            faRe[i] = re;
            faIm[i] = im;
        }

        fft(faRe, faIm, true);

        long[] res = new long[need];
        for (int i = 0; i < need; i++) {
            res[i] = Math.round(faRe[i]);
        }
        return res;
    }

    private static long[] convolutionSafe(long[] f) {
        final int BASE_BITS = 15;
        final long BASE = 1L << BASE_BITS;

        int n = f.length;
        long[] lo = new long[n];
        long[] hi = new long[n];
        for (int i = 0; i < n; i++) {
            lo[i] = f[i] & (BASE - 1);
            hi[i] = f[i] >>> BASE_BITS;
        }

        long[] ll = convolutionLong(lo, lo);
        long[] hh = convolutionLong(hi, hi);
        long[] lh = convolutionLong(lo, hi); // lo*hi

        long[] res = new long[ll.length];
        for (int i = 0; i < res.length; i++) {
            long LL = ll[i];
            long HH = hh[i];
            long LH = lh[i] * 2L;
            res[i] = LL + (LH << BASE_BITS) + (HH << (2 * BASE_BITS));
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        long nLong = fs.nextLong();
        int n = (int) nLong;

        long[] f = new long[n];
        for (long i = 1; i <= n - 1L; i++) {
            int r = (int) ((i * i) % n);
            f[r]++;
        }

        long[] conv = convolutionSafe(f);

        long[] g = new long[n];
        for (int k = 0; k < n; k++) {
            long v = conv[k];
            int idx = k + n;
            if (idx < conv.length) v += conv[idx];
            g[k] = v;
        }

        long T = 0;
        for (int k = 0; k < n; k++) {
            T += f[k] * g[k];
        }

        // E = sum f[x] * f[(2x) mod n]  (a=b 케이스)
        long E = 0;
        for (int x = 0; x < n; x++) {
            E += f[x] * f[(2 * x) % n];
        }

        long ans = (T + E) / 2;
        System.out.print(ans);
    }
}
