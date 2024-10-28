import java.util.Scanner;

public class Solution {
    public static int findMode(int[] scores) {
        // 점수는 0~100이므로 크기 101의 배열 사용
        int[] count = new int[101];
        
        // 점수 빈도 계산
        for (int score : scores) {
            count[score]++;
        }
        
        int maxCount = 0;
        int mode = 0;
        
        // 큰 점수부터 확인하여 최빈수 찾기 (내림차순)
        for (int i = 100; i >= 0; i--) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mode = i;
            }
        }
        
        return mode;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            int caseNum = sc.nextInt();
            int[] scores = new int[1000];
            
            for (int i = 0; i < 1000; i++) {
                scores[i] = sc.nextInt();
            }
            
            System.out.println("#" + caseNum + " " + findMode(scores));
        }
        
        sc.close();
    }
}