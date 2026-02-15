import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double D = Double.parseDouble(st.nextToken());
        double T = Double.parseDouble(st.nextToken());

        double dist = Math.hypot(x, y);
        double ans = dist; // 걷기만

        int base = (int)Math.floor(dist / D);

        // k번 점프 + 남은 거리 걷기 후보 (base 주변만 보면 됨)
        for (int k = Math.max(0, base - 2); k <= base + 2; k++) {
            if (k == 0) {
                ans = Math.min(ans, dist);
            } else {
                double cand = k * T + Math.abs(dist - k * D);
                ans = Math.min(ans, cand);
            }
        }

        // 점프만으로 정확히 도착 가능한 후보: kD >= dist 이고 k >= 2
        int kceil = (int)Math.ceil(dist / D);
        if (kceil <= 1) {
            // dist < D 인 경우 1번 점프로는 정확히 못 감(길이가 D 고정) → 2번 점프면 가능
            ans = Math.min(ans, 2 * T);
        } else {
            ans = Math.min(ans, kceil * T);
        }

        System.out.printf("%.10f%n", ans);
    }
}
