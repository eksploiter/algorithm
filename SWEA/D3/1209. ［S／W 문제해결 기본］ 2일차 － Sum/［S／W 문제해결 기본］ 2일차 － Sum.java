import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner  = new Scanner(System.in);
        int T = 10;
        for (int t = 1; t <= T; t++) {
        	scanner.nextInt();
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
            	for (int j = 0; j < 100; j++) {
                	arr[i][j] = scanner.nextInt();
                }
            }
            int maxSum = 0;
            // 각각의 행과 열의 합 계산 시 주의
            for (int i = 0; i < 100; i++) {
                int colSum = 0;
            	int rowSum = 0;
            	for (int j = 0; j < 100; j++) {
                	rowSum += arr[i][j];
                    colSum += arr[j][i];
                } 
                maxSum = Math.max(maxSum, (Math.max(rowSum, colSum)));
            }
            int diagonal1Sum = 0;
            int diagonal2Sum = 0;
            for (int i = 0; i < 100; i++) {
                diagonal1Sum += arr[i][i];
                diagonal2Sum += arr[i][99 - i];
            }
            maxSum = Math.max(maxSum, (Math.max(diagonal1Sum, diagonal2Sum)));
            System.out.println("#" + t + " " + maxSum);
        } 
        scanner.close();
    }
}