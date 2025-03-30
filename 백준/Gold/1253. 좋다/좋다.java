import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);
        int count = 0;

        for (int k = 0; k < N; k++) {
            int i = 0;
            int j = N - 1;

            while (i < j) {
                if (i == k) {
                    i++;
                    continue;
                } else if (j == k) {
                    j--;
                    continue;
                }

                long sum = arr[i] + arr[j];

                if (sum == arr[k]) {
                    count++;
                    break;
                } else if (sum < arr[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(count);
    }
}
