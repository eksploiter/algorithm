import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;
        
        S[0] = scanner.nextInt();
        for (int i = 1; i < N; i++) { // 수열 합 배열 만들기
            S[i] = S[i - 1] + scanner.nextInt();
        }
        for (int i = 0; i < N; i++) { // 합 배열의 모든 값에 % 연산 수행하기 
            int remainder = (int) (S[i] % M);
            // 0 ~ i 까지의 구산 합 자체가 0일 때 정답에 더하기
            if (remainder == 0) {
                answer++;
            }
            C[remainder]++;
        }
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}