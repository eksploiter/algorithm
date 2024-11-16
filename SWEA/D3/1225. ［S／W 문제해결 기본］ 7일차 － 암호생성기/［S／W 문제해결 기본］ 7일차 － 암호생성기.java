import java.util.Scanner;

public class Solution {
	public static void main(String[] ags) {
    	Scanner scanner = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
        	scanner.nextInt();
            int[] arr = new int[8];
            for (int i = 0; i < 8; i++) {
            	arr[i] = scanner.nextInt();
            }
            boolean isComplete = false;
            while (!isComplete) {
            	for (int i = 1; i <= 5; i++) {
                	arr[0] = arr[0] - i;
                    if (arr[0] <= 0) {
                    	arr[0] = 0;
                        isComplete = true;
                    }
                    int temp = arr[0];
                    for (int j = 0; j < 7; j++) {
                    	arr[j] = arr[j + 1];
                    }
                    arr[7] = temp;
                    if (isComplete) {
                    	break;
                    }
                }
            }
            System.out.print("#" + t + " ");
            for (int i = 0; i < 8; i++) {
            	System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}