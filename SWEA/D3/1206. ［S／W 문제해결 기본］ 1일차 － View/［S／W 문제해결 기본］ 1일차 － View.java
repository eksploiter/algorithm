import java.util.Scanner;
// 메서드를 사용해서 만들어보기
public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int T = 10;
        for (int t = 1; t <= 10; t++) {
        	int N = scanner.nextInt();
            int[] buildings = new int[N];
            for (int i = 0; i < N; i++) {
            	buildings[i] = scanner.nextInt();
            }
            System.out.println("#" + t + " " + bestView(buildings));
        }
        scanner.close();
    }
    public static int bestView(int[] buildings) {
    	int view = 0;
        for (int i = 2; i < buildings.length - 2; i++) {
        	int nextBuilding = Math.max(Math.max(buildings[i - 1], buildings[i - 2]), Math.max(buildings[i + 1], buildings[i + 2]));
            if (buildings[i] > nextBuilding) {
            	view += (buildings[i] - nextBuilding);
            }
        }
        return view;
    }
}