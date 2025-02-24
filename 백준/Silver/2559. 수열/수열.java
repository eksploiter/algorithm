import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        int maxSum = sum;

        // 슬라이딩 윈도우
        // 이전 창의 첫 요소를 빼고, 다음 요소를 더한다.
        for (int i = K; i < N; i++) {
            sum += arr[i] - arr[i - K];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}