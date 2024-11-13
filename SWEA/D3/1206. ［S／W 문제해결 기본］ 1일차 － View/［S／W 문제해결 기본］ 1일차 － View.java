import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
        	int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
            	arr[i] = scanner.nextInt();
            }
            int bestView = 0;
            for (int i = 2; i < N - 2; i++) {
            	int view = Math.max(Math.max(arr[i - 1], arr[i - 2]), Math.max(arr[i + 1], arr[i + 2]));
                if (arr[i] > view) {
                	bestView += arr[i] - view;
                }
            }
            System.out.println("#" + t + " " + bestView);
        }
        scanner.close();
    }
}