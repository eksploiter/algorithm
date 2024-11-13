import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
        	scanner.nextInt();
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
            	for (int j = 0; j <100; j++) {
                	arr[i][j] = scanner.nextInt();
                }
            }
            int maxSum = 0;
            for (int i = 0; i < 100; i++) {
            	int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                	rowSum += arr[i][j];
                    colSum += arr[j][i];
                }
                maxSum = Math.max(maxSum, Math.max(rowSum, colSum));
            }
            int diag1 = 0;
            int diag2 = 0;
            for (int i = 0; i < 100; i++) {
            	diag1 += arr[i][i];
                diag2 += arr[i][99 - i];
            }
            maxSum = Math.max(maxSum, Math.max(diag1, diag2));
            System.out.println("#" + t + " " + maxSum);
        }
        scanner.close();
    }
}