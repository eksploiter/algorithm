import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
        	int testCase = scanner.nextInt();
            int[] scores = new int[1000];
            for (int j = 0; j < 1000; j++) {
            	scores[j] = scanner.nextInt();
            }
            System.out.println("#" + testCase + " " + findMode(scores));
        }
        scanner.close();
    }
    
    public static int findMode(int[] scores) {
    	int[] count = new int[101];
        
        for (int score : scores) {
        	count[score]++;
        }
        
        int maxCount = 0;
        int mode = 0;
        for (int i = 0; i < count.length; i++) {
        	if (count[i] > maxCount) {
            	maxCount = count[i]; // 가장 큰 빈도수 
                mode = i; // 가장 큰 빈도수를 가진 점수
            } else if (count[i] == maxCount && i > mode) {
            	mode = i;
            }
        }
        return mode;
    }
}
