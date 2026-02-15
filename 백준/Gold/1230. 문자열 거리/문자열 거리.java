import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String O = br.readLine();
        String N = br.readLine();

        int m = O.length();
        int n = N.length();

        if (m > n) { // 삽입만 가능하므로 길이가 더 길면 불가능
            System.out.println(-1);
            return;
        }

        // prev0[j] : O의 i글자를 만들고 N의 j글자까지 처리했을 때,
        //            마지막 문자가 "매칭"으로 끝난 상태(삽입 덩어리 밖)
        // prev1[j] : 마지막 문자가 "삽입"으로 끝난 상태(삽입 덩어리 안)
        int[] prev0 = new int[n + 1];
        int[] prev1 = new int[n + 1];

        Arrays.fill(prev0, INF);
        Arrays.fill(prev1, INF);

        // i = 0 (O를 0글자 만들기)
        prev0[0] = 0;
        prev1[0] = INF;
        for (int j = 1; j <= n; j++) {
            prev0[j] = INF; // 매칭으로 끝날 수 없음
            prev1[j] = 1;   // N의 앞 j글자를 한 덩어리로 "삽입"하면 됨
        }

        for (int i = 0; i < m; i++) {
            int[] cur0 = new int[n + 1];
            int[] cur1 = new int[n + 1];
            Arrays.fill(cur0, INF);
            Arrays.fill(cur1, INF);

            // j=0은 N을 0글자 처리한 상태라서 삽입/매칭으로 끝날 수 없음 (i+1 > 0)
            cur0[0] = INF;
            cur1[0] = INF;

            for (int j = 0; j < n; j++) {
                // 1) N[j]를 "삽입"으로 처리 -> 상태 1로 감
                //    - 이미 삽입 덩어리 진행 중이면 덩어리 수 증가 없음
                if (cur1[j] < cur1[j + 1]) cur1[j + 1] = cur1[j];

                //    - 매칭 상태에서 삽입을 시작하면 "새 덩어리" 시작 -> +1
                if (cur0[j] != INF) {
                    int cand = cur0[j] + 1;
                    if (cand < cur1[j + 1]) cur1[j + 1] = cand;
                }

                // 2) N[j]를 O[i]와 "매칭" (가능할 때만) -> 상태 0
                if (O.charAt(i) == N.charAt(j)) {
                    int bestPrev = Math.min(prev0[j], prev1[j]);
                    if (bestPrev < cur0[j + 1]) cur0[j + 1] = bestPrev;
                }
            }

            prev0 = cur0;
            prev1 = cur1;
        }

        int ans = Math.min(prev0[n], prev1[n]);
        System.out.println(ans >= INF ? -1 : ans);
    }
}
