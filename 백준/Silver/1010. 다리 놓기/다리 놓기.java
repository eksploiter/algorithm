import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long ans = combination(M, N);

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    static long combination(int M, int N) {
        if (N == 0 || N == M) {
            return 1;
        }

        long result = 1;

        for (int i = 1; i <= N; i++) {
            result = result * (M - i + 1) / i;
        }

        return result;
    }
}
