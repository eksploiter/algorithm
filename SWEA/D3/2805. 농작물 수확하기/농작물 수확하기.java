import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
        	int N = scanner.nextInt();
            int[][] farm = new int[N][N];
            for (int i = 0; i < N; i++) {
            	String line = scanner.next();
                for (int j = 0; j < N; j++) {
                	farm[i][j] = line.charAt(j) - '0';
                }
            }
            System.out.println("#" + t + " " + find(N, farm));
        }
        scanner.close();
    }
    public static int find(int N, int[][] farm) {
    	
        int radius = (N - 1) / 2;
        int center = N / 2;
        int sum = 0;
        for (int i = -radius; i <= radius; i++) {
        	for (int j = -radius; j <= radius; j++) {
            	if (Math.abs(i) + Math.abs(j) <= radius) {
                	sum += farm[center + i][center + j];
                }
            }
        }
        return sum;
    }
}