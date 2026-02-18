import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 900528;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 20);

        String charset = br.readLine();   // 사용할 수 있는 문자들 (순서 중요)
        String password = br.readLine();  // 컴퓨터의 암호

        int n = charset.length();

        // char -> 1..n 매핑 (UTF-16 범위까지 커버)
        int[] map = new int[65536];
        Arrays.fill(map, -1);
        for (int i = 0; i < n; i++) {
            map[charset.charAt(i)] = i + 1; // 1-based
        }

        long ans = 0;
        for (int i = 0; i < password.length(); i++) {
            int digit = map[password.charAt(i)]; // 1..n
            ans = (ans * n + digit) % MOD;
        }

        System.out.println(ans);
    }
}
