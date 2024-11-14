import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        for (int t =1; t <= 10; t++) {
        	scanner.nextInt();
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int answer = 1;
            for (int i = 0; i < M; i++) {
            	answer *= N;
            }
            System.out.println("#" + t + " " + answer);
        }
        scanner.close();
    }
}