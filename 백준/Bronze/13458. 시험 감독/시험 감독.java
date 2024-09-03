import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 시험장의 개수 N을 입력받음
        int N = scanner.nextInt();

        // 각 시험장의 응시자 수를 저장할 배열
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // 총감독관이 감시할 수 있는 응시자 수 B와 부감독관이 감시할 수 있는 응시자 수 C를 입력받음
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        // 필요한 감독관 수의 최솟값을 저장할 변수
        long totalSupervisors = 0;

        // 각 시험장마다 필요한 감독관 수를 계산
        for (int i = 0; i < N; i++) {
            // 먼저 총감독관을 배치
            totalSupervisors++;

            // 남은 응시자 수 계산
            int remaining = A[i] - B;

            // 남은 응시자가 있다면 부감독관 배치
            if (remaining > 0) {
                // 부감독관이 필요한 수는 남은 응시자를 C로 나눈 몫
                totalSupervisors += (remaining + C - 1) / C;  // 올림 계산
            }
        }

        // 결과 출력
        System.out.println(totalSupervisors);
    }
}
