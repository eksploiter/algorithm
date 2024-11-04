import java.util.Scanner;
// 메서드 사용하지 않고 만들어보기
public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
        	scanner.nextInt();
            int[] scores = new int[1000];
            for (int i = 0; i < 1000; i++) {
            	scores[i] = scanner.nextInt();
            }
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
            System.out.println("#" + t + " " + mode);
        }
        scanner.close();
    }
}