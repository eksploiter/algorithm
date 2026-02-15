import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    static long[][] mul(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        c[0][0] = (a[0][0]*b[0][0] + a[0][1]*b[1][0]) % MOD;
        c[0][1] = (a[0][0]*b[0][1] + a[0][1]*b[1][1]) % MOD;
        c[1][0] = (a[1][0]*b[0][0] + a[1][1]*b[1][0]) % MOD;
        c[1][1] = (a[1][0]*b[0][1] + a[1][1]*b[1][1]) % MOD;
        return c;
    }

    static long[][] pow(long n) {
        // base matrix
        long[][] base = {{1, 1}, {1, 0}};
        // identity
        long[][] res = {{1, 0}, {0, 1}};

        while (n > 0) {
            if ((n & 1L) == 1L) res = mul(res, base);
            base = mul(base, base);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());

        if (N == 0) {
            System.out.println(0);
            return;
        }

        long[][] m = pow(N);
        System.out.println(m[0][1] % MOD); // F(N)
    }
}
