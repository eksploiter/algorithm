import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = 10;
        for (int t = 1; t  <= 10; t++) {
            int N = scanner.nextInt();
            int[] building = new int[N];
            for (int i = 0; i < N; i++) {
            	building[i] = scanner.nextInt();
            }
            int view = 0;
            for (int i = 2; i < N - 2; i++) {
            	int max = Math.max(Math.max(building[i - 2], building[i - 1]), Math.max(building[i + 1], building[i + 2]));
                
                if (building[i] > max) {
                	view += (building[i] - max);
                }
            }
            System.out.println("#" + t + " " + view);
        }
        scanner.close();
    }
}