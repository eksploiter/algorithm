import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        for (int t = 1; t <= 10; t++) {
            int testCaseNum = scanner.nextInt(); // 테스트 케이스 번호 입력
            
            int[][] matrix = new int[100][100];
            
            // 100x100 배열 입력 받기
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            int maxSum = 0;
            
            // 각 행의 합과 각 열의 합을 동시에 계산
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    rowSum += matrix[i][j]; // 행의 합
                    colSum += matrix[j][i]; // 열의 합
                }
                maxSum = Math.max(maxSum, Math.max(rowSum, colSum));
            }
            
            // 대각선의 합 계산
            int diagonal1Sum = 0;
            int diagonal2Sum = 0;
            for (int i = 0; i < 100; i++) {
                diagonal1Sum += matrix[i][i];
                diagonal2Sum += matrix[i][99 - i];
            }
            maxSum = Math.max(maxSum, Math.max(diagonal1Sum, diagonal2Sum));
            
            // 결과 출력
            System.out.println("#" + testCaseNum + " " + maxSum);
        }
        scanner.close();
    }
}