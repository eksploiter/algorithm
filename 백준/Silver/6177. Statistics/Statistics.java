import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            //st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        double average = (double) sum / N;
        System.out.printf("%.6f\n", average);

        if (N % 2 == 0) {
            double ans1 = (double) (arr[N / 2 - 1] + arr[N / 2]) / 2;
            System.out.printf("%.6f\n", ans1);
        } else {
            double ans2 = arr[N / 2];
            System.out.printf("%.6f\n", ans2);
        }
    }
}
