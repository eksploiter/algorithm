import java.io.*;
import java.util.*;

public class Main {
    static long N, P, Q;
    static HashMap<Long, Long> memo = new HashMap<>();

    static long solve(long n) {
        if (n == 0) return 1;
        Long cached = memo.get(n);
        if (cached != null) return cached;

        long val = solve(n / P) + solve(n / Q);
        memo.put(n, val);
        return val;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        System.out.println(solve(N));
    }
}
