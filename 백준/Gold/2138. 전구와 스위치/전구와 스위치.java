import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] start, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        start = new int[n];
        target = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = s1[i] - '0';
            target[i] = s2[i] - '0';
        }

        int notPress = simulate(Arrays.copyOf(start, n), false);
        int press = simulate(Arrays.copyOf(start, n), true);

        int answer = Integer.MAX_VALUE;
        if (notPress != -1) answer = Math.min(answer, notPress);
        if (press != -1) answer = Math.min(answer, press + 1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static int simulate(int[] bulbs, boolean pressFirst) {
        int count = 0;

        if (pressFirst) {
            toggle(bulbs, 0);
        }

        for (int i = 1; i < n; i++) {
            if (bulbs[i - 1] != target[i - 1]) {
                toggle(bulbs, i);
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (bulbs[i] != target[i]) return -1;
        }

        return count;
    }

    static void toggle(int[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < n) {
                arr[i] = 1 - arr[i];
            }
        }
    }
}
