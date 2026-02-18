import java.io.*;
import java.util.*;

public class Main {
    static final long LIMIT = 1_000_000_001L; // 1e9 초과 시 출력값
    static final long INF = Long.MAX_VALUE / 4;

    static class Term {
        long coef;
        String name;
        Term(long c, String n) { coef = c; name = n; }
    }

    static class Formula {
        String target;
        List<Term> terms = new ArrayList<>();
        Formula(String t) { target = t; }
    }

    // 비용 합산 (LIMIT로 캡)
    static long cappedAddMul(long sum, long coef, long val) {
        if (sum >= LIMIT) return LIMIT;
        if (val >= LIMIT) return LIMIT;

        // coef * val이 LIMIT 넘어가면 바로 캡
        // (coef, val은 양수)
        if (coef != 0 && val > (LIMIT - 1) / coef) return LIMIT;

        long prod = coef * val;
        long res = sum + prod;
        return res >= LIMIT ? LIMIT : res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Long> cost = new HashMap<>();
        List<Formula> formulas = new ArrayList<>();

        // 초기 재료 비용
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long c = Long.parseLong(st.nextToken());
            c = Math.min(c, LIMIT);
            cost.put(name, Math.min(cost.getOrDefault(name, INF), c));
        }

        // 조합식 파싱
        for (int i = 0; i < M; i++) {
            String line = br.readLine().trim(); // 공백 없음(문제 특성)
            int eq = line.indexOf('=');

            String left = line.substring(0, eq);
            String right = line.substring(eq + 1);

            cost.putIfAbsent(left, INF);

            Formula f = new Formula(left);

            int idx = 0;
            while (idx < right.length()) {
                // term 하나: (숫자들)? + (이름)
                long coef = 0;
                boolean hasDigit = false;

                while (idx < right.length() && Character.isDigit(right.charAt(idx))) {
                    hasDigit = true;
                    coef = coef * 10 + (right.charAt(idx) - '0');
                    idx++;
                }
                if (!hasDigit) coef = 1; // 계수 생략이면 1

                StringBuilder name = new StringBuilder();
                while (idx < right.length() && right.charAt(idx) != '+') {
                    name.append(right.charAt(idx));
                    idx++;
                }
                if (idx < right.length() && right.charAt(idx) == '+') idx++; // '+' 스킵

                String ing = name.toString();
                cost.putIfAbsent(ing, INF);
                f.terms.add(new Term(coef, ing));
            }

            formulas.add(f);
        }

        int iterLimit = cost.size() + M + 5;
        for (int it = 0; it < iterLimit; it++) {
            boolean changed = false;

            for (Formula f : formulas) {
                long sum = 0;
                boolean ok = true;

                for (Term t : f.terms) {
                    long v = cost.getOrDefault(t.name, INF);
                    if (v >= INF) { ok = false; break; }
                    sum = cappedAddMul(sum, t.coef, v);
                    if (sum >= LIMIT) { // 더해도 의미 없음
                        // 계속은 하되 캡 상태 유지
                    }
                }

                if (!ok) continue;

                long cur = cost.getOrDefault(f.target, INF);
                if (sum < cur) {
                    cost.put(f.target, sum);
                    changed = true;
                }
            }

            if (!changed) break;
        }

        long ans = cost.getOrDefault("LOVE", INF);
        if (ans >= INF) System.out.println(-1);
        else System.out.println(Math.min(ans, LIMIT));
    }
}
