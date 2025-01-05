import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스 수 입력
        
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt(); // 행렬 크기 입력
            int[][] arr = new int[N][N];
            
            // 행렬 입력 받기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            
            // 각 회전된 결과 계산
            int[][] rotated90 = rotate90(N, arr);
            int[][] rotated180 = rotate90(N, rotated90);
            int[][] rotated270 = rotate90(N, rotated180);
            
            // 출력
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                printRow(rotated90[i]);
                System.out.print(" ");
                printRow(rotated180[i]);
                System.out.print(" ");
                printRow(rotated270[i]);
                System.out.println();
            }
        }
        scanner.close();
    }

    // 90도 회전 메서드
    public static int[][] rotate90(int N, int[][] arr) {
        int[][] rotated = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }

    // 행 출력 메서드
    public static void printRow(int[] row) {
        for (int num : row) {
            System.out.print(num);
        }
    }
}
