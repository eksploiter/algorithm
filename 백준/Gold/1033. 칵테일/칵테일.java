import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        BigInteger mul; // current * mul / div
        BigInteger div;
        Edge(int to, BigInteger mul, BigInteger div) {
            this.to = to;
            this.mul = mul;
            this.div = div;
        }
    }

    static class Fraction {
        BigInteger num, den; // num/den, den>0

        Fraction(BigInteger num, BigInteger den) {
            if (den.signum() < 0) { // keep denominator positive
                num = num.negate();
                den = den.negate();
            }
            BigInteger g = num.gcd(den);
            this.num = num.divide(g);
            this.den = den.divide(g);
        }

        Fraction mulDiv(BigInteger mul, BigInteger div) {
            // (num/den) * mul / div = (num*mul)/(den*div) then reduce
            BigInteger n = this.num.multiply(mul);
            BigInteger d = this.den.multiply(div);
            BigInteger g = n.gcd(d);
            return new Fraction(n.divide(g), d.divide(g));
        }
    }

    static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.divide(a.gcd(b)).multiply(b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] g = new ArrayList[N];
        for (int i = 0; i < N; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            BigInteger p = new BigInteger(st.nextToken());
            BigInteger q = new BigInteger(st.nextToken());

            // A[a] / A[b] = p / q
            // so from a -> b : A[b] = A[a] * q / p
            // and from b -> a : A[a] = A[b] * p / q
            g[a].add(new Edge(b, q, p));
            g[b].add(new Edge(a, p, q));
        }

        Fraction[] frac = new Fraction[N];
        boolean[] vis = new boolean[N];

        // DFS from 0
        Deque<Integer> stack = new ArrayDeque<>();
        frac[0] = new Fraction(BigInteger.ONE, BigInteger.ONE);
        vis[0] = true;
        stack.push(0);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (Edge e : g[cur]) {
                if (vis[e.to]) continue;
                vis[e.to] = true;
                frac[e.to] = frac[cur].mulDiv(e.mul, e.div);
                stack.push(e.to);
            }
        }

        // LCM of denominators
        BigInteger lcmDen = BigInteger.ONE;
        for (int i = 0; i < N; i++) {
            lcmDen = lcm(lcmDen, frac[i].den);
        }

        // Convert to integers
        BigInteger[] ans = new BigInteger[N];
        for (int i = 0; i < N; i++) {
            BigInteger scale = lcmDen.divide(frac[i].den);
            ans[i] = frac[i].num.multiply(scale);
        }

        // Reduce by gcd of all
        BigInteger gcdAll = ans[0];
        for (int i = 1; i < N; i++) gcdAll = gcdAll.gcd(ans[i]);
        for (int i = 0; i < N; i++) ans[i] = ans[i].divide(gcdAll);

        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans[i].toString());
        }
        System.out.println(sb);
    }
}