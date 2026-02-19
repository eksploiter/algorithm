import java.io.*;
import java.util.*;

public class Main {
    static final int SIZE = 5;
    static final int CELLS = 25;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static int K;
    static int[] origR, origC;
    static int answer = Integer.MAX_VALUE;

    static int[] targetIdx;          // 선택된 목표 칸 인덱스(0..24)
    static boolean[] chosen = new boolean[CELLS];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> stars = new ArrayList<>();

        for (int r = 0; r < SIZE; r++) {
            String line = br.readLine();
            for (int c = 0; c < SIZE; c++) {
                if (line.charAt(c) == '*') stars.add(new int[]{r, c});
            }
        }

        K = stars.size();
        origR = new int[K];
        origC = new int[K];
        for (int i = 0; i < K; i++) {
            origR[i] = stars.get(i)[0];
            origC[i] = stars.get(i)[1];
        }

        // K개 목표 칸 조합 생성
        targetIdx = new int[K];
        comb(0, 0);

        System.out.println(answer);
    }

    // 25칸 중 K개 뽑는 조합
    static void comb(int start, int depth) {
        if (depth == K) {
            if (!isConnected()) return;
            answer = Math.min(answer, minMatchingCost());
            return;
        }
        // 가지치기: 남은 칸 수가 부족하면 종료
        if (CELLS - start < K - depth) return;

        for (int i = start; i < CELLS; i++) {
            chosen[i] = true;
            targetIdx[depth] = i;
            comb(i + 1, depth + 1);
            chosen[i] = false;
        }
    }

    // 선택된 K개 칸이 4방향 연결인지 체크
    static boolean isConnected() {
        int start = targetIdx[0];
        boolean[] vis = new boolean[CELLS];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int r = cur / SIZE;
            int c = cur % SIZE;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= SIZE || nc < 0 || nc >= SIZE) continue;
                int ni = nr * SIZE + nc;
                if (!chosen[ni] || vis[ni]) continue;
                vis[ni] = true;
                cnt++;
                q.add(ni);
            }
        }
        return cnt == K;
    }

    // 현재 K개 조각을 목표 K개 칸으로 옮기는 최소 이동합 (비트마스크 DP)
    static int minMatchingCost() {
        int[] tr = new int[K];
        int[] tc = new int[K];
        for (int i = 0; i < K; i++) {
            int idx = targetIdx[i];
            tr[i] = idx / SIZE;
            tc[i] = idx % SIZE;
        }

        int maxMask = 1 << K;
        int[] dp = new int[maxMask];
        Arrays.fill(dp, Integer.MAX_VALUE / 4);
        dp[0] = 0;

        for (int mask = 0; mask < maxMask; mask++) {
            int i = Integer.bitCount(mask); // 지금까지 i개의 원본 조각을 배정함
            if (i >= K) continue;

            int base = dp[mask];
            if (base >= Integer.MAX_VALUE / 8) continue;

            for (int j = 0; j < K; j++) {
                if ((mask & (1 << j)) != 0) continue;
                int cost = Math.abs(origR[i] - tr[j]) + Math.abs(origC[i] - tc[j]);
                int nmask = mask | (1 << j);
                dp[nmask] = Math.min(dp[nmask], base + cost);
            }
        }

        return dp[maxMask - 1];
    }
}
