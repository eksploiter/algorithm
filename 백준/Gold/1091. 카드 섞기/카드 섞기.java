import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] P, S;

    static boolean isGoal(int[] deck) {
        // deck[pos] = 그 위치에 있는 카드 번호
        for (int pos = 0; pos < N; pos++) {
            int card = deck[pos];
            if (P[card] != (pos % 3)) return false;
        }
        return true;
    }

    static boolean same(int[] a, int[] b) {
        for (int i = 0; i < N; i++) if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        P = new int[N];
        S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());

        int[] deck = new int[N];
        int[] init = new int[N];
        for (int i = 0; i < N; i++) {
            deck[i] = i;
            init[i] = i;
        }

        if (isGoal(deck)) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        int[] next = new int[N];

        while (true) {
            // 한 번 섞기: 현재 position i의 카드는 position S[i]로 이동
            for (int i = 0; i < N; i++) {
                next[S[i]] = deck[i];
            }

            // swap
            int[] tmp = deck;
            deck = next;
            next = tmp;

            cnt++;

            if (isGoal(deck)) {
                System.out.println(cnt);
                return;
            }

            // 다시 초기 상태로 돌아오면, 이후로는 반복이므로 불가능
            if (same(deck, init)) {
                System.out.println(-1);
                return;
            }
        }
    }
}
