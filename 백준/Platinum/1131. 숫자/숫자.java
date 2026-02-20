import java.io.*;
import java.util.*;

public class Main {
    static final int LIMIT = 1_000_000;

    static int A, B, K;
    static int[] pow = new int[10];

    // memo[x] : x로 시작하는 수열에서 등장하는 최솟값 (x는 1..LIMIT)
    //  0  = 미계산
    // -1  = 현재 재귀 경로(방문중)
    static int[] memo = new int[LIMIT + 1];

    static int calc(long n) {
        int sum = 0;
        while (n > 0) {
            sum += pow[(int)(n % 10)];
            n /= 10;
        }
        return sum;
    }

    // 다음 값이 LIMIT를 넘으면 계속 줄여서 LIMIT 이하로 만든 뒤 반환
    static int nextSmall(long n) {
        int x = (n <= LIMIT) ? (int)n : calc(n);
        while (x > LIMIT) x = calc(x);
        return x;
    }

    static int minimal(long n) {
        int x = nextSmall(n);          // 항상 1..LIMIT로 정규화해서 처리
        if (memo[x] > 0) return memo[x];

        if (memo[x] == -1) {
            // 사이클 발견: x부터 한 바퀴 돌면서 사이클 최소값을 구해 전부 채움
            int mn = x;
            int cur = nextSmall(calc(x));
            while (cur != x) {
                mn = Math.min(mn, cur);
                cur = nextSmall(calc(cur));
            }
            // 사이클 노드들 memo에 최소값 기록
            memo[x] = mn;
            cur = nextSmall(calc(x));
            while (cur != x) {
                memo[cur] = mn;
                cur = nextSmall(calc(cur));
            }
            return mn;
        }

        memo[x] = -1; // 방문중 표시
        int t = minimal(nextSmall(calc(x))); // 다음으로 진행
        int res = Math.min(x, t);
        memo[x] = res;
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // digit^K
        for (int d = 0; d <= 9; d++) {
            int v = 1;
            for (int i = 0; i < K; i++) v *= d;
            pow[d] = v;
        }

        long ans = 0;
        for (int n = A; n <= B; n++) {
            ans += minimal(n);
        }
        System.out.println(ans);
    }
}