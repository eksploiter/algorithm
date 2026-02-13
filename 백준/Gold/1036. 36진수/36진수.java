import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int val(char ch) {
        if ('0' <= ch && ch <= '9') return ch - '0';
        return ch - 'A' + 10;
    }

    static char digit(int v) {
        if (v < 10) return (char)('0' + v);
        return (char)('A' + (v - 10));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        String[] arr = new String[N];

        // 각 digit(0~35)이 각 "자리 지수 p"에 몇 번 등장했는지 카운트
        // p는 최대 문자열 길이 - 1 (오른쪽이 0제곱)
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().trim();
            maxLen = Math.max(maxLen, arr[i].length());
        }

        int K = Integer.parseInt(br.readLine().trim());

        // pow36[p] = 36^p (BigInteger)
        BigInteger[] pow36 = new BigInteger[maxLen + 1];
        pow36[0] = BigInteger.ONE;
        for (int p = 1; p <= maxLen; p++) {
            pow36[p] = pow36[p - 1].multiply(BigInteger.valueOf(36));
        }

        // count[d][p] = digit d가 36^p 자리에서 등장한 횟수
        long[][] count = new long[36][maxLen + 1];

        // 원래 합 계산 + 카운트
        BigInteger sum = BigInteger.ZERO;

        for (String s : arr) {
            // 문자열을 36진수 BigInteger로 변환해 sum에 더하기
            BigInteger cur = BigInteger.ZERO;
            for (int i = 0; i < s.length(); i++) {
                cur = cur.multiply(BigInteger.valueOf(36)).add(BigInteger.valueOf(val(s.charAt(i))));
            }
            sum = sum.add(cur);

            // 자리별 카운트: 오른쪽 끝이 p=0
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(len - 1 - i);
                int d = val(ch);
                count[d][i]++;
            }
        }

        // 각 digit을 Z로 바꿀 때의 이득 gain[d] 계산
        BigInteger[] gain = new BigInteger[36];
        for (int d = 0; d < 36; d++) {
            BigInteger g = BigInteger.ZERO;
            int diff = 35 - d;
            if (diff == 0) {
                gain[d] = BigInteger.ZERO;
                continue;
            }
            BigInteger diffBI = BigInteger.valueOf(diff);
            for (int p = 0; p <= maxLen; p++) {
                if (count[d][p] == 0) continue;
                BigInteger add = pow36[p].multiply(diffBI).multiply(BigInteger.valueOf(count[d][p]));
                g = g.add(add);
            }
            gain[d] = g;
        }

        // gain 큰 순으로 digit 정렬
        Integer[] idx = new Integer[36];
        for (int i = 0; i < 36; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> gain[b].compareTo(gain[a]));

        // 상위 K개(이득>0인 것만) 적용
        BigInteger totalGain = BigInteger.ZERO;
        int picked = 0;
        for (int i = 0; i < 36 && picked < K; i++) {
            int d = idx[i];
            if (gain[d].signum() <= 0) break;
            totalGain = totalGain.add(gain[d]);
            picked++;
        }

        BigInteger result = sum.add(totalGain);

        // 결과를 36진수로 출력 (BigInteger는 toString(radix) 제공)
        String ans = result.toString(36).toUpperCase();
        System.out.println(ans);
    }
}
