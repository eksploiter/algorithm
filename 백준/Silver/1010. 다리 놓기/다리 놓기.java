import java.util.Scanner;

public class Main {

    // 조합을 계산하는 함수
    public static long combination(int m, int n) {
        if (n == 0 || n == m) {
            return 1;
        }

        long result = 1;

        // 조합 공식 적용 C(M, N) = M! / (N! * (M-N)!)
        for (int i = 1; i <= n; i++) {
            result = result * (m - i + 1) / i;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            // 조합 계산하여 출력
            System.out.println(combination(M, N));
        }

        sc.close();
    }
}
