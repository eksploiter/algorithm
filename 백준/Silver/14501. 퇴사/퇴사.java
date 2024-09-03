import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] T = new int[N + 1]; // 상담 기간
        int[] P = new int[N + 1]; // 상담 금액
        int[] dp = new int[N + 2]; // 최대 수익을 저장할 DP 테이블
        
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }
        
        // DP 알고리즘 적용
        for (int i = N; i > 0; i--) {
            int nextDay = i + T[i];
            
            // 상담을 진행할 수 있는 경우
            if (nextDay <= N + 1) {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[nextDay]);
            } else {
                // 상담을 진행할 수 없는 경우
                dp[i] = dp[i + 1];
            }
        }
        
        // 결과 출력
        System.out.println(dp[1]);
        
        sc.close();
    }
}
