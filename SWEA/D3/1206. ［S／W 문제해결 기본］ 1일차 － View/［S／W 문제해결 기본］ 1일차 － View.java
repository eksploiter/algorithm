import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = 10;
        for (int t = 1; t <= 10; t++) {
        	int N = scanner.nextInt();
            int[] buildings = new int[N];
            for (int i = 0; i < N; i++) {
            	buildings[i] = scanner.nextInt();
            }
            System.out.println("#" + t + " " + find(N, buildings));
        }
        scanner.close();
    }
    public static int find(int N, int[] buildings) {
    	int bestView = 0; 
        for (int i = 2; i < N - 2; i++) {
        	int view = Math.max(Math.max(buildings[i - 1], buildings[i - 2]), Math.max(buildings[i + 1], buildings[i + 2]));
            if (buildings[i] > view) {
            	bestView += (buildings[i] - view);
            }
        }
        return bestView;
    } 
}