import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'A']++;
        }

        int oddCount = 0;
        int oddIdx = -1;
        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                oddCount++;
                oddIdx = i;
            }
        }

        if (oddCount >= 2) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int half = cnt[i] / 2;
            for (int k = 0; k < half; k++) left.append((char)('A' + i));
        }

        String mid = "";
        if (oddIdx != -1) mid = String.valueOf((char)('A' + oddIdx));

        StringBuilder right = new StringBuilder(left).reverse();

        System.out.println(left.toString() + mid + right.toString());
    }
}
