import java.io.*;
import java.util.*;

public class Main {

    // 0부터 n까지 자릿수 합 (n < 0 이면 0)
    static long sumDigitsUpTo(long n) {
        if (n < 0) return 0;

        long sum = 0;
        for (long factor = 1; factor <= n; factor *= 10) {
            long lower = n % factor;
            long cur = (n / factor) % 10;
            long higher = n / (factor * 10);

            // higher * (0~9 합 45) * factor
            sum += higher * 45L * factor;

            // 현재 자리 cur가 만드는 추가: (0..cur-1)의 합 * factor
            sum += (cur * (cur - 1) / 2) * factor;

            // 현재 자리 cur가 lower+1 번 반복됨
            sum += cur * (lower + 1);

            // overflow 방지: factor*10이 long 넘길 수 있으니 다음 루프 조건을 안전하게
            if (factor > Long.MAX_VALUE / 10) break;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        if (A > B) { // 혹시 모르니 스왑
            long tmp = A; A = B; B = tmp;
        }

        long ans = sumDigitsUpTo(B) - sumDigitsUpTo(A - 1);
        System.out.println(ans);
    }
}
