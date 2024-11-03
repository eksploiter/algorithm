import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = 10;
        for (int i = 1; i <= 10; i++) {
            int caseNum = scanner.nextInt();
        	int N = scanner.nextInt();
            int M = scanner.nextInt();
            System.out.println("#" + caseNum + " " + find(N, M));
        }
        scanner.close();
    }
    public static int find(int N, int M) {
    	int answer = 1;
        for (int i = 0; i < M; i++) {
        	answer *= N;
        }
        return answer;
    }
}