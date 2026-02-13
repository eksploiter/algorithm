import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] h = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) h[i] = Long.parseLong(st.nextToken());

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;

            // 오른쪽: 기울기 최대 갱신
            boolean hasRight = false;
            long bestNumR = 0; // (h[j]-h[i])
            long bestDenR = 1; // (j-i) > 0

            for (int j = i + 1; j < N; j++) {
                long num = h[j] - h[i];
                long den = j - i; // 양수

                if (!hasRight) {
                    hasRight = true;
                    bestNumR = num;
                    bestDenR = den;
                    cnt++;
                } else {
                    // num/den > bestNumR/bestDenR ?
                    if (num * bestDenR > bestNumR * den) {
                        bestNumR = num;
                        bestDenR = den;
                        cnt++;
                    }
                }
            }

            // 왼쪽: i에서 j(i-1..0)로 갈 때 "기울기 최대" 갱신 (분모는 양수로 통일)
            boolean hasLeft = false;
            long bestNumL = 0; // (h[j]-h[i])
            long bestDenL = 1; // (i-j) > 0

            for (int j = i - 1; j >= 0; j--) {
                long num = h[j] - h[i];
                long den = i - j; // 양수

                if (!hasLeft) {
                    hasLeft = true;
                    bestNumL = num;
                    bestDenL = den;
                    cnt++;
                } else {
                    // 왼쪽도 "더 큰 기울기"를 만나면 새로 보임
                    if (num * bestDenL > bestNumL * den) {
                        bestNumL = num;
                        bestDenL = den;
                        cnt++;
                    }
                }
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
