import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> lucky = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        // 1) 금민수(4/7만) 생성
        genLucky(0);
        Collections.sort(lucky);

        // 2) BFS: sum(0..N)
        boolean[] vis = new boolean[N + 1];
        int[] prev = new int[N + 1];
        int[] used = new int[N + 1];
        Arrays.fill(prev, -1);

        int[] q = new int[N + 1];
        int head = 0, tail = 0;

        vis[0] = true;
        q[tail++] = 0;

        while (head < tail) {
            int cur = q[head++];
            if (cur == N) break;

            for (int num : lucky) {
                int nxt = cur + num;
                if (nxt > N) break;          // 오름차순이므로 이후도 전부 초과
                if (vis[nxt]) continue;

                vis[nxt] = true;
                prev[nxt] = cur;
                used[nxt] = num;
                q[tail++] = nxt;
            }
        }

        if (!vis[N]) {
            System.out.println(-1);
            return;
        }

        // 3) 경로 복원 (0 -> N)
        ArrayList<Integer> ans = new ArrayList<>();
        int x = N;
        while (x != 0) {
            ans.add(used[x]);
            x = prev[x];
        }
        Collections.reverse(ans);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans.get(i));
        }
        System.out.println(sb);
    }

    // cur에 4/7을 붙이며 N 이하만 수집
    static void genLucky(long cur) {
        if (cur > N) return;
        if (cur != 0) lucky.add((int) cur);

        long a = cur * 10 + 4;
        long b = cur * 10 + 7;
        if (a <= N) genLucky(a);
        if (b <= N) genLucky(b);
    }
}
