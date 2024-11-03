import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = 10;
        for (int i = 1; i <= 10; i++) {
        	int N = scanner.nextInt();
            int[] buildings = new int[N];
            for (int j = 0; j < N; j++) {
            	buildings[j] = scanner.nextInt();
            }
            int bestView = 0;
            for (int j = 2; j < N - 2; j++) {
            	int view = Math.max(Math.max(buildings[j - 1], buildings[j - 2]), Math.max(buildings[j + 1], buildings[j + 2]));
                if (buildings[j] > view) {
                	bestView += (buildings[j] - view);
                }
            }
            System.out.println("#" + i + " " + bestView);
        }
        scanner.close();
    }
}