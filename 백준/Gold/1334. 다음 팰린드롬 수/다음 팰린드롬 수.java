import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();

        // 1) all 9s 처리: 9, 99, 999 -> 11, 101, 1001 ...
        boolean all9 = true;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '9') {
                all9 = false;
                break;
            }
        }
        if (all9) {
            StringBuilder ans = new StringBuilder();
            ans.append('1');
            for (int i = 0; i < n - 1; i++) ans.append('0');
            ans.append('1');
            System.out.println(ans);
            return;
        }

        // 2) 미러링해서 팰린드롬 만들기
        char[] a = s.toCharArray();
        mirror(a);

        String pal = new String(a);
        if (pal.compareTo(s) > 0) { // 같은 길이이므로 사전식 비교로 OK
            System.out.println(pal);
            return;
        }

        int i = (n - 1) / 2; // 왼쪽 중앙
        int j = n / 2;       // 오른쪽 중앙 (홀수면 i==j)
        int carry = 1;

        while (i >= 0 && carry > 0) {
            int d = (a[i] - '0') + carry;
            a[i] = (char) ('0' + (d % 10));
            carry = d / 10;

            a[j] = a[i]; // 중앙/대칭 즉시 반영
            i--;
            j++;
        }

        mirror(a);
        System.out.println(new String(a));
    }

    private static void mirror(char[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            a[n - 1 - i] = a[i];
        }
    }
}
