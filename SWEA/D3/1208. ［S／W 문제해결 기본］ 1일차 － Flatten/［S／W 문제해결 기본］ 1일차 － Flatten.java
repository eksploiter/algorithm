import java.util.Scanner;
// 메서드를 사용해서 풀어보기
public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = 10;
        for (int t = 1; t <= 10; t++) {
        	int N = scanner.nextInt();
            int[] boxs = new int[100];
            for (int i = 0; i < 100; i++) {
            	boxs[i] = scanner.nextInt();
            }
            System.out.println("#" + t + " " + flatten(N, boxs));
        }
        scanner.close();
    }
    public static int flatten(int N, int[] boxs) {
        for (int i  = 0; i < N; i++) {
            int maxHigh = 0;
        	int maxLow = 0;
        	for (int j = 1; j < 100; j++) {
            	if (boxs[j] > boxs[maxHigh]) {
                	maxHigh = j;
                }
                if (boxs[j] < boxs[maxLow]) {
                	maxLow = j;
                } 
            } 
            boxs[maxHigh] -= 1;
            boxs[maxLow] += 1;
        }
        int maxHigh = 0;
        int maxLow = 0;
        for (int i = 1; i <100; i++) {
        	if (boxs[i] > boxs[maxHigh]) {
            	maxHigh = i;
            }
            if (boxs[i] < boxs[maxLow]) {
            	maxLow = i;
            }
        }
        int answer = boxs[maxHigh] - boxs[maxLow];
        return answer;
    }
}