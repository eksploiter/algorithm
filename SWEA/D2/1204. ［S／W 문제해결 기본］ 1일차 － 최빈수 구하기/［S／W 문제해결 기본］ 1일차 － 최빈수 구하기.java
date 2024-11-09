import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= 10; t++) {
        	scanner.nextInt();
            int[] scores = new int[1000];
            for (int i = 0; i < 1000; i++) {
            	scores[i] = scanner.nextInt();
            } 
            System.out.println("#" + t + " " + find(scores));
        }
        scanner.close();
    }
    public static int find(int[] scores) {
    	int[] count = new int[101];
        for (int i = 0; i < 1000; i++) {
        	count[scores[i]]++;
        }
        int maxCount = 0;
        int score = 0;
        for (int i = 0; i < 101; i++) {
        	if (count[i] > maxCount) {
            	maxCount = count[i];
                score = i;
            } else if (count[i] == maxCount && i > score) {
            	score = i;
            }
        }
        return score;
    }
}