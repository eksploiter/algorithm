import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, rank;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (rank[a] < rank[b]) {
            parent[a] = b;
        } else if (rank[a] > rank[b]) {
            parent[b] = a;
        } else {
            parent[b] = a;
            rank[a]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 진실 아는 사람들
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] truth = new int[T];
        for (int i = 0; i < T; i++) truth[i] = Integer.parseInt(st.nextToken());

        // 파티 정보 저장 (나중에 판별해야 하므로)
        int[][] parties = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            parties[i] = new int[k];
            for (int j = 0; j < k; j++) parties[i][j] = Integer.parseInt(st.nextToken());

            // 같은 파티 참석자들 union
            for (int j = 1; j < k; j++) {
                union(parties[i][0], parties[i][j]);
            }
        }

        // 진실 집합 루트들을 표시
        boolean[] truthRoot = new boolean[N + 1];
        for (int x : truth) truthRoot[find(x)] = true;

        // 파티마다 거짓말 가능 여부 판단
        int ans = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : parties[i]) {
                if (truthRoot[find(person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) ans++;
        }

        System.out.println(ans);
    }
}
