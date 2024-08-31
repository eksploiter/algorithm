import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N: 바구니의 개수, M: 작업의 수
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        // 바구니를 0으로 초기화
        int[] baskets = new int[N];

        // M번의 작업 처리
        for (int m = 0; m < M; m++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int k = scanner.nextInt();

            // i번 바구니부터 j번 바구니까지 k번 공을 넣음
            for (int b = i - 1; b < j; b++) {
                baskets[b] = k;
            }
        }

        // 결과 출력
        for (int b = 0; b < N; b++) {
            System.out.print(baskets[b] + " ");
        }
    }
}
