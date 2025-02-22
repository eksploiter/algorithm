import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int sum = 0;
        int K = Integer.parseInt(st.nextToken());
        sum += K;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            sum += A;
            int B = Integer.parseInt(st.nextToken());
            sum -= B;
        }

        System.out.println("비와이");
    }
}