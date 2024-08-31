import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // N: 수의 개수, M: 합을 구해야 하는 횟수
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] numbers = new int[N + 1];  // 주어진 수 배열 (1-based index)
        int[] prefix = new int[N + 1];   // 누적 합 배열 (1-based index)

        // 수 입력과 동시에 누적 합 계산
        for (int i = 1; i <= N; i++) {
            numbers[i] = scanner.nextInt();
            prefix[i] = prefix[i - 1] + numbers[i];
        }

        // M개의 구간 합 계산 및 출력
        for (int m = 0; m < M; m++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            // 구간 합 출력
            System.out.println(prefix[j] - prefix[i - 1]);
        }
    }
}

