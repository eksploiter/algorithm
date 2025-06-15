import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        HashSet<Integer> sums = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sums.add(arr[i] + arr[j]);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                int d = arr[i];
                int c = arr[j];
                if (sums.contains(d - c)) {
                    System.out.println(d);
                    return;
                }
            }
        }
    }
}
