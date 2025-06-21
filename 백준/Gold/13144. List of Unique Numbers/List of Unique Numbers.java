import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[100_001];
        long ans = 0;
        int L = 1, R = 1;

        while (L <= N) {
            while (R <= N && cnt[nums[R]] == 0) {
                cnt[nums[R]]++;
                R++;
            }
            ans += (R - L);
            cnt[nums[L]]--;
            L++;
        }

        System.out.println(ans);
    }
}
