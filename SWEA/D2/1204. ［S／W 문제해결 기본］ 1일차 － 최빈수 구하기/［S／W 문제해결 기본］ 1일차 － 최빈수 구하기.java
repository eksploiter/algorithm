import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner  = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
        	scanner.nextInt();
            int[] scores = new int[1000];
            for (int i = 0; i < 1000; i++) {
            	scores[i] = scanner.nextInt();
            }
            System.out.println("#" + t + " " + findMode(scores));
        }
        scanner.close();
    }
    public static int findMode(int[] scores) {
    	int[] count = new int[101];
        for (int i = 0; i < scores.length; i++) {
        	count[scores[i]]++;
        }
        int maxCount = 0; 
        int mode = 0;
        for (int i = 0; i < count.length; i++) {
        	if (count[i] > maxCount) {
            	maxCount = count[i];
                mode = i;
            } else if (count[i] == maxCount && i > mode) {
            	mode = i;
            }
        }
        return mode;
    }
}