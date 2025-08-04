import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long[] arr = new long[K];
        long maxLen = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextLong();
            if (arr[i] > maxLen) {
                maxLen = arr[i];
            }
        }

        long low = 1, high = maxLen, result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for (long len : arr) {
                count += (len / mid);
            }
            if (count >= N) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
