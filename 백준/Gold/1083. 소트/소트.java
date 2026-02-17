import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N && S > 0; i++) {
            int end = Math.min(N - 1, i + S);

            int maxIdx = i;
            for (int j = i + 1; j <= end; j++) {
                if (a[j] > a[maxIdx]) maxIdx = j;
            }

            int dist = maxIdx - i;
            if (dist > 0) {
                int val = a[maxIdx];
                for (int j = maxIdx; j > i; j--) {
                    a[j] = a[j - 1];
                }
                a[i] = val;
                S -= dist;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(a[i]);
        }
        System.out.print(sb);
    }
}
