import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] ars) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = K * N - M;

        if (M > (K * N)) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
