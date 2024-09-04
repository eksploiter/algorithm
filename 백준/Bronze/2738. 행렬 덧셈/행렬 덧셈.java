import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행렬의 크기 N과 M 입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 두 행렬 A와 B 선언 및 초기화
        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        int[][] result = new int[N][M];

        // 행렬 A 입력받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 행렬 B 입력받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // 행렬 A와 B의 합을 result에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        // 결과 행렬 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
