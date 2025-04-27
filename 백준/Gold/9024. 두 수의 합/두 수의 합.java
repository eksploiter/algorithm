import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);  // 정렬
            int left = 0, right = N - 1;

            int minDiff = Integer.MAX_VALUE;
            int count = 0;

            while (left < right) {
                int sum = arr[left] + arr[right];
                int diff = Math.abs(K - sum);

                if (diff < minDiff) {
                    minDiff = diff;
                    count = 1;
                } else if (diff == minDiff) {
                    count++;
                }

                if (sum < K) {
                    left++;
                } else {
                    right--;
                }
            }

            System.out.println(count);
        }
    }
}
