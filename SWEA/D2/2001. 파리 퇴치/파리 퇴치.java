import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = scanner.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }

            sb.append("#").append(tc).append(" ").append(found(arr, N, M)).append("\n");
        }

        System.out.println(sb);
        scanner.close();
    }

    static int found(int[][] arr, int N, int M) {
        int[][] arrSum = new int[N + 1][N + 1];

        // 누적 합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arrSum[i][j] = arrSum[i][j - 1] 
                            + arrSum[i - 1][j] 
                            - arrSum[i - 1][j - 1] 
                            + arr[i - 1][j - 1];
            }
        }

        int maxKill = 0;

        // M×M 크기의 부분합을 구해서 최댓값 갱신
        for (int i = M - 1; i < N; i++) {
            for (int j = M - 1; j < N; j++) {
                int sum = arrSum[i + 1][j + 1] 
                        - arrSum[i + 1 - M][j + 1] 
                        - arrSum[i + 1][j + 1 - M] 
                        + arrSum[i + 1 - M][j + 1 - M];
                maxKill = Math.max(maxKill, sum);
            }
        }
        return maxKill;
    }
}
