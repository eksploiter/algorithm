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
        	System.out.println("#" + t + " " + flatten(N, arr));
        }
        scanner.close();
    }
    public static int flatten(int N, int[] arr) {
    	for (int i = 0; i < N; i++) {
        	int top = 0;
            int bottom = 0;
            for (int j = 0; j < arr.length; j++) {
            	if (arr[j] > arr[top]) {
                	top = j;
                }
                if (arr[j] < arr[bottom]) {
                	bottom = j;
                }
            }
            arr[top] -= 1;
            arr[bottom] += 1;
        }
        int top = 0; 
        int bottom = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] > arr[top]) {
            	top = i;
            }
            if (arr[i] < arr[bottom]) {
            	bottom = i;
            }
        }
        return arr[top] - arr[bottom];
    }
}