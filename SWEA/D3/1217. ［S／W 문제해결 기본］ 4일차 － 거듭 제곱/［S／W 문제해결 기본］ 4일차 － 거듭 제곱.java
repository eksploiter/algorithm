import java.util.Scanner;
// 메서드 사용하지 않고 풀어보기
public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = 10;
        for (int i = 1; i <= T; i++) {
            scanner.nextInt();
        	int N = scanner.nextInt();
            int M = scanner.nextInt();
            int answer = 1;
            for (int j = 0; j < M; j++) {
            	answer *= N;
            }
            System.out.println("#" + i + " " + answer); 
        }
        scanner.close();
    }
}