import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
        	int N = scanner.nextInt();
            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
            	arr[i] = scanner.nextInt();
            }
            System.out.println("#" + t + " " + find(N, arr));
        }
        scanner.close();
    }
    public static int find(int N, int[] arr) {
    	for (int i = 0; i < N; i++) {
        	int high = 0;
            int low = 0;
            for (int j = 1; j < 100; j++) {
            	if (arr[j] > arr[high]) {
                	high = j;
                }
                if (arr[j] < arr[low]) {
                	low = j;
                }
            }
            arr[high] -= 1;
            arr[low] += 1;
        }
        int high = 0;
        int low = 0;
        for (int i = 0; i < 100; i++) {
        	if (arr[i] > arr[high]) {
            	high = i;
            }
            if (arr[i] < arr[low]) {
            	low = i;
            }
        }
        return arr[high] - arr[low];
    }
}