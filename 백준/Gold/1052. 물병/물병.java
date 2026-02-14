import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K >= N) { // N개를 1L로 산다고 치면 합치지 않아도 K 이하 가능
            System.out.println(0);
            return;
        }

        int answer = 0;

        while (Integer.bitCount(N) > K) {
            int lowbit = N & -N;   // 가장 낮은 1비트(2^t)
            answer += lowbit;      // 그만큼 물병을 추가로 산다(= N을 올린다)
            N += lowbit;
        }

        System.out.println(answer);
    }
}
