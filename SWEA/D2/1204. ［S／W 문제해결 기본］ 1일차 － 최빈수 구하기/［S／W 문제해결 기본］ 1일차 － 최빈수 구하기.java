import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
        	scanner.nextInt();
            int[] scores = new int[1000];
            for (int j = 0; j < 1000; j++) {
            	scores[j] = scanner.nextInt();
            }
            System.out.println("#" + i + " " + find(scores));
        }
        scanner.close();
    }
    public static int find(int[] scores) {
    	int[] count = new int[101];
        for (int i = 0; i < scores.length; i++) {
            // for (int score : scores)
        	count[scores[i]]++;
            // 향상된 for 문 사용시
			// count[score]++;
        }
        int maxCount = 0; // 가장 큰 빈도수
        int mode = 0; // 빈도수가 가장 높은 점수
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